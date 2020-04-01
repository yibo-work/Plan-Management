package com.clrvn.classroom.mapper;

import com.classroom.pojo.Classroom;
import com.classroom.vo.ClassroomApplyVO;
import com.classroom.vo.ClassroomCourseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassroomMapper {
    
    List<Classroom> queryClassroomList(@Param("type") Integer type, @Param("name") String name);
    
    int addClassroom(@Param("classroom") Classroom classroom);
    
    List<Classroom> getAllClassroom();
    
    Classroom getClassroomById(@Param("id") Integer id);
    
    int updateClassroom(@Param("classroom") Classroom classroom);
    
    int removeClassroomById(@Param("id") Integer id);
    
    List<ClassroomApplyVO> queryClassroomTimeListByIdApply(@Param("id") Integer id);
    
    List<ClassroomCourseVO> queryClassroomTimeListByIdCourse(@Param("id") Integer id);
}
