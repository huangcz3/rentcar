package com.bs.mapper;

import com.bs.pojo.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {
    @Select("select * from menus where  menuid in "
            + " (select menuid from roles_menus where roleid=#{param1} ) "
            + " and fatherid =#{param2} ")
    List<Menu> selMenu(int roleid, int fatherid);

    @Select("select * from menus where fatherid=#{param1}")
    List<Menu> selAll(int fatherid);
}
