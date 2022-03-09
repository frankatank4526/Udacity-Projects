package com.udacity.jdnd.course1.data;

import org.apache.ibatis.annotations.*;

@Mapper
public interface DeliveryMapper {
    @Select("SELECT * FROM Delivery WHERE id = #{id}")
    Delivery findDelivery(int id);

    @Insert("INSERT INTO Delivery (orderID, time)" +
            "VALUES (#{orderID}, #{time})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertDelivery(Delivery delivery);

    @Delete("DELETE FROM Delivery WHERE id = #{id}")
    void deleteDelivery(int id);

}
