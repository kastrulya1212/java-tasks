package com.univ_java_task_7.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import com.univ_java_task_7.demo.model.Railcar;
import com.univ_java_task_7.demo.model.RailcarOperation;

@Mapper
public interface RailcarMapper {        
    // Basic hard operations
//     @Delete("DROP SCHEMA IF EXISTS app_schem CASCADE; DROP SCHEMA IF EXISTS public CASCADE;")
//     void clearAllSchemas();

    // Railcars CRUD
    @Select("SELECT * FROM app_schem.railcars")
    List<Railcar> findAllRailcars();

    @Select("SELECT * FROM app_schem.railcars WHERE railcar_num = #{railcar_num}")
    Railcar findByRailcarNum(@Param("railcar_num") Long railcar_num);
    
    @Insert("INSERT INTO app_schem.railcars (railcar_num, railcar_type, railcar_capacity_tons, railcar_owner_company) " +
            "VALUES (#{railcar_num}, #{railcar_type}, #{railcar_capacity_tons}, #{railcar_owner_company})")
    void insertRailcar(Railcar railcar);

    @Delete("DELETE FROM app_schem.railcars WHERE railcar_num = #{railcar_num}")
    void deleteByRailcarNum(@Param("railcar_num") Long railcar_num);

    @Update("UPDATE app_schem.railcars SET railcar_type = #{railcar_type}, " +
            "railcar_capacity_tons = #{railcar_capacity_tons}, " +
            "railcar_owner_company = #{railcar_owner_company} " +
            "WHERE railcar_num = #{railcar_num}")
    void updateRailcar(@Param("railcar_num") Long railcar_num, @Param("railcar_type") String railcar_type,
                       @Param("railcar_capacity_tons") Double railcar_capacity_tons, @Param("railcar_owner_company") String railcar_owner_company);


    // RailcarOperations CRUD
    @Select("SELECT * FROM app_schem.railcar_operations")
    List<RailcarOperation> findAllOperations();

    @Select("SELECT * FROM app_schem.railcar_operations WHERE id = #{id} ")
    RailcarOperation findOperationById(@Param("id") Long id);

    @Select("SELECT * FROM app_schem.railcar_operations WHERE railcar_num = #{railcar_num}")
    List<RailcarOperation> findOperationsByRailcarNum(@Param("railcar_num") Long railcar_num);
    
    @Select("SELECT * FROM app_schem.railcar_operations WHERE operation_type = #{operation_type}")
    List<RailcarOperation> findOperationsByOperationType(@Param("operation_type") String operation_type);
    
    @Insert("INSERT INTO app_schem.railcar_operations (railcar_num, operation_type, operation_status, station_from, station_to) " +
            "VALUES (#{railcar_num}, #{operation_type}, #{operation_status}, #{station_from}, #{station_to})")
    void insertRailcarOperation(RailcarOperation railcarOperation);

    @Delete("DELETE FROM app_schem.railcar_operations WHERE id = #{id}")
    void deleteRailcarOperationById(@Param("id") Long id);

    @Update("UPDATE app_schem.railcar_operations SET operation_type = #{operation_type}, " +
            "operation_status = #{operation_status}, station_from = #{station_from}, station_to = #{station_to} " +
            "WHERE id = #{id}")
    void updateRailcarOperation(@Param("id") Long id, @Param("operation_type") String operation_type,
                                @Param("operation_status") String operation_status, @Param("station_from") String station_from,
                                @Param("station_to") String station_to);
}


