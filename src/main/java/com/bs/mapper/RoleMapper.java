package com.bs.mapper;

import com.bs.pojo.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoleMapper {
    /**
     * 添加角色
     *
     * @param roleid
     * @param menuid
     * @return
     */
    @Insert("insert into roles values(default,#{param1})")
    int insRole(String rolename);

    /**
     * 通过名字查找
     *
     * @param rolename
     * @return
     */
    @Select("select * from roles where rolename=#{param1}")
    Role selByName(String rolename);

    /**
     * 查询所有角色
     *
     * @return
     */
    @Select("select * from roles")
    List<Role> selAll();

    /**
     * 根据编号查询角色
     *
     * @param roleid
     * @return
     */
    @Select("select * from roles where roleid=#{0}")
    Role selById(int roleid);

    /**
     * 根据编号删除角色
     *
     * @param roleid
     * @return
     */
    @Delete("delete from roles where  roleid=#{0}")
    int delRole(int roleid);

    /**
     * 根据编号更新角色信息
     *
     * @param role
     * @return
     */
    @Update("update roles set rolename=#{rolename} where roleid=#{roleid}")
    int updateRole(Role role);

    /**
     * @param role
     * @return
     */
    List<Role> selRole(Role role);
}
