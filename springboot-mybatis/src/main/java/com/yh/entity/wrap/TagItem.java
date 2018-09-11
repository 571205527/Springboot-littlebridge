package com.yh.entity.wrap;

import com.yh.entity.AssessItem;

import java.io.Serializable;
import java.util.List;

/**
 * @Created by: LHZ
 * @Description:
 */
public class TagItem  implements Serializable{

    private String id;

    private Byte tagType;

    private String tagName;

    private List<AssessItem> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<AssessItem> getItems() {
        return items;
    }

    public void setItems(List<AssessItem> items) {
        this.items = items;
    }

    public Byte getTagType() {
        return tagType;
    }

    public void setTagType(Byte tagType) {
        this.tagType = tagType;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
