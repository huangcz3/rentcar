package com.bs.mapper;

import com.bs.pojo.Checktable;
import com.bs.pojo.Renttable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChecktableMapper {
    @Insert("insert into checktable values"
            + " (#{checkid},#{checkdate},#{field},"
            + "#{problem},#{paying},#{username},#{rentid})")
    int add(Checktable checktable);

    @Select("select * from checktable where checkid=#{param1}")
    Renttable findById(String checkid);

    @Select("select count(*) from checktable")
    int findCount();

    List<Checktable> findChecktable(@Param("checktable") Checktable checktable, @Param("index") int start, @Param("size") int size);

}
