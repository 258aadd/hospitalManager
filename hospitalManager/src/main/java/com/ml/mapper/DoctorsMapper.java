package com.ml.mapper;

import com.ml.pojo.Doctors;
import com.ml.pojo.DoctorsQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;
import java.util.List;

public interface DoctorsMapper {

    @Select("select * from doctors where job_number = #{uname} and password = #{password}")
    Doctors login(@Param("uname") String name, @Param("password") String password) throws SQLException;

    @Select("select max(job_number) from doctors")
    String getJobNumberMax() throws SQLException;

    @Insert("insert into doctors(job_number,password,department_id) values (#{jobNum},'123456',#{did})")
    void addDoctor(@Param("did") String did,@Param("jobNum") int jobNum) throws SQLException;

    List<Doctors> getDoctorList(DoctorsQuery doctorsQuery) throws SQLException;

    @Update("update doctors set state=1 where doctor_id=#{id}")
    void deleteById(String id) throws SQLException;

    @Update("update doctors set name=#{name},avatar=#{avatar},phone=#{phone},email=#{email},introduction=#{introduction},registration_fee=#{registration_fee},entry_date=#{entry_date},professional_title_id=#{professional_title_id} where job_number=#{job_number}")
    void updateDoctorByJobNumber(Doctors doctor) throws SQLException;

}
/*全部上传标签*/