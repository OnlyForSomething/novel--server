package com.getnovel.novel.pojo;

public class NovelType {
    private Integer typeId;
    private String typeName;
    private String typeIcon;

    public String getTypeIcon() {
        return typeIcon;
    }

    public void setTypeIcon(String typeIcon) {
        this.typeIcon = typeIcon;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "NovelType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", typeIcon='" + typeIcon + '\'' +
                '}';
    }
}
