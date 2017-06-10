
package com.developers.chukimmuoi.reactiveprogram.data.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Singer {

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("searchResultId")
    @Expose
    private int searchResultId;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("updateAt")
    @Expose
    private String updateAt;
    @SerializedName("piority")
    @Expose
    private int piority;
    @SerializedName("isActive")
    @Expose
    private boolean isActive;
    @SerializedName("createAt")
    @Expose
    private String createAt;
    @SerializedName("createBy")
    @Expose
    private Object createBy;
    @SerializedName("nameOfSearch")
    @Expose
    private String nameOfSearch;
    @SerializedName("updateBy")
    @Expose
    private Object updateBy;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("shortName")
    @Expose
    private String shortName;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSearchResultId() {
        return searchResultId;
    }

    public void setSearchResultId(int searchResultId) {
        this.searchResultId = searchResultId;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public int getPiority() {
        return piority;
    }

    public void setPiority(int piority) {
        this.piority = piority;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public Object getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Object createBy) {
        this.createBy = createBy;
    }

    public String getNameOfSearch() {
        return nameOfSearch;
    }

    public void setNameOfSearch(String nameOfSearch) {
        this.nameOfSearch = nameOfSearch;
    }

    public Object getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }
}
