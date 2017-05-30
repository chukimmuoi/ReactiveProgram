
package com.developers.chukimmuoi.reactiveprogram.object;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Style {

    @SerializedName("createBy")
    @Expose
    private String createBy;
    @SerializedName("updateBy")
    @Expose
    private String updateBy;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("updateAt")
    @Expose
    private String updateAt;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("isActive")
    @Expose
    private int isActive;
    @SerializedName("createAt")
    @Expose
    private String createAt;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }
}
