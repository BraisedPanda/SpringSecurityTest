package com.braisedpanda.web.mapper;

import com.braisedpanda.commons.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper  extends tk.mybatis.mapper.common.Mapper<User>{
}
