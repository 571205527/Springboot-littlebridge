package com.yh.entity.wrap;

import java.io.Serializable;

/**
 * @Created by: LHZ
 * @Description:
 */
public class EventPush implements Serializable {

    private String cardNo;
    private String title;
    private String pictureUrl;
    private String content;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EventPush{" +
                "cardNo='" + cardNo + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
