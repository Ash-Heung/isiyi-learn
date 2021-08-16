package com.isiyi.base;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: DateSplit
 * @author: 向鹏飞
 * @since: 2021/7/29
 */
public class DateSplit {
    /***
     * 分段时间如12:00~12:30
     */
    private String segmentTime;
    /***
     * 时间段的开始时间
     */
    private Date startTime;
    /***
     * 时间段的结束时间
     */
    private Date endTime;

    public DateSplit() {
    }

    public DateSplit(String segmentTime, Date startTime, Date endTime) {
        this.segmentTime = segmentTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public static DateSplit init(Date startTime, Date endTime){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        String s = simpleDateFormat.format(startTime);
        String e = simpleDateFormat.format(endTime);
        String segmentTime = s + "~" + e;
        return new DateSplit(segmentTime, startTime, endTime);
    }


}
