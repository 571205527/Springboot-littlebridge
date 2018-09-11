package com.yh.entity.wrap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HR on 2018/5/18.
 */
public class ItemStatistics implements Serializable {



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<ItemTimeStatisticsFollowTime> getItemTimeStatisticsFollowTimes() {
        return itemTimeStatisticsFollowTimes;
    }

    public void setItemTimeStatisticsFollowTimes(List<ItemTimeStatisticsFollowTime> itemTimeStatisticsFollowTimes) {
        this.itemTimeStatisticsFollowTimes = itemTimeStatisticsFollowTimes;
    }

    private String time;
    private List<ItemTimeStatisticsFollowTime> itemTimeStatisticsFollowTimes = new ArrayList<>();
}
