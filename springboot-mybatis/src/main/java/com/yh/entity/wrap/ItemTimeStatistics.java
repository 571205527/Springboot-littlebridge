package com.yh.entity.wrap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HR on 2018/5/19.
 */
public class ItemTimeStatistics implements Serializable {

    private String tagName;
    private List<ItemStatistics> itemStatisticsList = new ArrayList<>();

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<ItemStatistics> getItemStatisticsList() {
        return itemStatisticsList;
    }

    public void setItemStatisticsList(List<ItemStatistics> itemStatisticsList) {
        this.itemStatisticsList = itemStatisticsList;
    }
}
