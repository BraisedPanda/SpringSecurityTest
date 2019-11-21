package com.braisedpanda.web.utils;
import org.springframework.util.DigestUtils;

import java.security.NoSuchAlgorithmException;

/**
 * @program: admin-dashboard
 * @description:

 * @create: 2019-11-21 11:32
 **/
public class MD5Utils {



    public static String MD5Encoder(String password) throws NoSuchAlgorithmException {
       String result =  DigestUtils.md5DigestAsHex(password.getBytes());
        return result;
    }


}
