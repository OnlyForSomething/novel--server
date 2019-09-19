package com.getnovel.novel.pojo;


public class Novel {
    private Integer num;//mybatis mapping中用到的keyproperty 需要有setter方法

    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }

    private Integer novelId;//小说ID
    private String novelName;//小说名
    private String novelType;//小说种类
    private String author;//小说作者
    private String cover;//小说封面
    private String words;//小说字数
    private Integer totalChapters;//总章节数
    private String lastChapter;//最新章节
    private String novelStatus;//小说状态
    private Integer collectedAmount; //收藏人数
    private Integer starsAmount; //关注人数

    public Integer getNovelId() {
        return novelId;
    }

    public void setNovelId(Integer novelId) {
        this.novelId = novelId;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public String getNovelType() {
        return novelType;
    }

    public void setNovelType(String novelType) {
        this.novelType = novelType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public Integer getTotalChapters() {
        return totalChapters;
    }

    public void setTotalChapters(Integer totalChapters) {
        this.totalChapters = totalChapters;
    }

    public String getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public String getNovelStatus() {
        return novelStatus;
    }

    public void setNovelStatus(String novelStatus) {
        this.novelStatus = novelStatus;
    }

    public Integer getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedAmount(Integer collectedAmount) {
        this.collectedAmount = collectedAmount;
    }

    public Integer getStarsAmount() {
        return starsAmount;
    }

    public void setStarsAmount(Integer starsAmount) {
        this.starsAmount = starsAmount;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "num=" + num +
                ", novelId=" + novelId +
                ", novelName='" + novelName + '\'' +
                ", novelType='" + novelType + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", words='" + words + '\'' +
                ", totalChapters=" + totalChapters +
                ", lastChapter='" + lastChapter + '\'' +
                ", novelStatus='" + novelStatus + '\'' +
                ", collectedAmount=" + collectedAmount +
                ", starsAmount=" + starsAmount +
                '}';
    }
}
