package com.yh.mapper;

import com.yh.entity.EventLog;
import com.yh.entity.wrap.TimeLine;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface EventLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EventLog record);

    int insertSelective(EventLog record);

    EventLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(@RequestBody  EventLog record);

    int updateByPrimaryKey(EventLog record);

    int insertBatch(List<EventLog> eventLogs);

    int insertBatchSelective(List<EventLog> eventLogs);

    List<EventLog> selectByDate(@Param("date") String date);

    List<TimeLine> getTimeLine(@Param("date") String date, @Param("classId") Long classId, @Param("stuId") Long stuId, @Param("tchId") Long tchId, @Param("role") Byte role, @Param("cid") Long cid);

    List<TimeLine> getCommon(@Param("date") String date, @Param("classId") Long classId, @Param("stuId") Long stuId);

    List<TimeLine> getCardLog(@Param("date") String date, @Param("classId") Long classId, @Param("stuId") Long stuId);

    List<TimeLine> selectByTag(@Param("tchId") Long tchId, @Param("eventCategory") Long eventCategory, @Param("start") String start, @Param("end") String end,@Param("role") Byte role, @Param("cid") Long cid);

    List<TimeLine> selectOtherClass(@Param("tchId") Long tchId, @Param("eventCategory") Long eventCategory, @Param("start") String start, @Param("end") String end,@Param("role") Byte role, @Param("cid") Long cid);
}