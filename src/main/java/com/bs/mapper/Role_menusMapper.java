package com.bs.mapper;

import com.bs.pojo.Role_menus;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Role_menusMapper {

    int insRole_menus(List<Role_menus> list);

    @Delete("delete from roles_menus where roleid=#{roleid}")
    int delByRol(int roleid);

    /**
     * @param roleid
     * @return
     */
    @Select("select * from roles_menus where roleid=#{param1}")
    List<Role_menus> selById(int roleid);
}
