package it.linksmt.academy.micro.bff.web.model;

import java.util.Date;

public class AttendanceSearchDTO {

    private String userId;

    public Date getAttendanceDateFrom() {
        return attendanceDateFrom;
    }

    public void setAttendanceDateFrom(Date attendanceDateFrom) {
        this.attendanceDateFrom = attendanceDateFrom;
    }

    private Date attendanceDateFrom;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
