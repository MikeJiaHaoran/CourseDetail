package com.example.coursedetail.model.coursedetail;

public class LiveSyllabusList1 {
    private String scheduleId;
    private String scheduleName;
    private String scheduleTime;
    private String status;
    private String teacherName;
    private String serialNo;

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return "LiveSyllabusList{" +
                "scheduleId='" + scheduleId + '\'' +
                ", scheduleName='" + scheduleName + '\'' +
                ", scheduleTime='" + scheduleTime + '\'' +
                ", status='" + status + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", serialNo='" + serialNo + '\'' +
                '}';
    }
}
