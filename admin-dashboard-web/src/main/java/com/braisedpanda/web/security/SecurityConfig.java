package com.braisedpanda.web.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @program: admin-dashboard
 * @description: 配置拦截和验证
 * @create: 2019-11-21 08:46
 **/
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Resource
    private  DataSource dataSource;

    @Autowired
    private PersistentTokenRepository tokenRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private MyAuthenticationProvider provider;  //注入我们自己的AuthenticationProvider

    /**
    * @Description: 授权配置

    * @Date: 2019/11/21 0021
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**登录授权*/
        http
                .authorizeRequests().antMatchers("/css/**","/js/**","/fonts/**","/login/**","/sass/**","/fonts/**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/regist/**","/toregist/**").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()   //其余页面都需要登录
                .and().formLogin().loginPage("/tologin")            //表单登录页面
                .loginProcessingUrl("/login")                       //表单登录方法
                .permitAll()

                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .rememberMe()
                .tokenRepository(tokenRepository) // 设置数据访问层
                .rememberMeServices(rememberMeServices())
                .key("INTERNAL_SECRET_KEY")
                .tokenValiditySeconds(30) // 记住我的时间(秒)
                .and()
                .csrf().disable();

        /**session失效管理*/
        http.sessionManagement().invalidSessionUrl("/tologin");

        /**退出删除cookie*/
        http.logout().deleteCookies("JESSIONID");

        /**解决中文乱码问题*/
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter,CsrfFilter.class);

    }


    /**
     * @Description: 验证身份类

     * @Date: 2019/11/21 0021
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.authenticationProvider(provider);

    }

    /**生成remember-me token存入数据库**/
    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);

        return tokenRepository;
    }
    /** remember-me 在指定的时间内可以免登陆**/
    @Bean
    public RememberMeServices rememberMeServices() {
        JdbcTokenRepositoryImpl rememberMeTokenRepository = new JdbcTokenRepositoryImpl();
        // 此处需要设置数据源，否则无法从数据库查询验证信息
        rememberMeTokenRepository.setDataSource(dataSource);

        // 此处的 key 可以为任意非空值(null 或 "")，但必须和前面保持一致

        PersistentTokenBasedRememberMeServices rememberMeServices =
                new PersistentTokenBasedRememberMeServices("INTERNAL_SECRET_KEY", userDetailsService, rememberMeTokenRepository);

        return rememberMeServices;
    }

}
