package com.bs.mapper;

import com.bs.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface CarMapper {

    @Insert("insert into cars values"
            + " (#{carnumber},#{cartype},#{color},#{price},#{rentprice},#{deposit},#{isrenting},#{cardesc},#{carimg})")
    int add(Car car);

    /**
     * 查找总行数
     *
     * @return
     */
    @Select("select count(*) from cars ")
    int findCount();

    /**
     * 根据条件查询
     *
     * @param car
     * @param start
     * @param size
     * @return
     */
    List<Car> findCar(@Param("car") Car car, @Param("index") int start, @Param("size") int size);

    /**
     * 获取单个
     *
     * @param carnumber
     * @return
     */
    @Select("select * from cars where carnumber=#{param1}")
    Car findByNum(String carnumber);

    /**
     * 修改
     *
     * @param car
     * @return
     */
    @Update("update cars set "
            + " cartype=#{cartype},color=#{color},price=#{price}, "
            + " rentprice=#{rentprice},deposit=#{deposit},"
            + " isrenting=#{isrenting},cardesc=#{cardesc},carimg=#{carimg} "
            + " where carnumber=#{carnumber}")
    int updateCar(Car car);

    /**
     * 删除
     *
     * @param carnumber
     * @return
     */
    @Delete("delete from cars where carnumber=#{param1}")
    int delByIdent(String carnumber);

    /**
     * 租车
     *
     * @param carnumber
     * @return
     */
    @Update("update cars set  isrenting=1 "
            + " where carnumber=#{param1}")
    int updateCarRent(String carnumber);

    /**
     * 还车
     *
     * @param carnumber
     * @return
     */
    @Update("update cars set  isrenting=0"
            + " where carnumber=#{param1}")
    int updateReturn(String carnumber);

}
