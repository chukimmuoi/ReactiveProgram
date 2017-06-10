
package com.developers.chukimmuoi.reactiveprogram.data.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Song {

    @SerializedName("singers")
    @Expose
    private List<Singer> singers = null;
    @SerializedName("fileDownload")
    @Expose
    private String fileDownload;
    @SerializedName("searchResultId")
    @Expose
    private int searchResultId;
    @SerializedName("isDuet")
    @Expose
    private boolean isDuet;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("updateAt")
    @Expose
    private String updateAt;
    @SerializedName("isActive")
    @Expose
    private boolean isActive;
    @SerializedName("singerName")
    @Expose
    private String singerName;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("singerId")
    @Expose
    private String singerId;
    @SerializedName("downloadEndpoint")
    @Expose
    private String downloadEndpoint;
    @SerializedName("nameOfSearch")
    @Expose
    private String nameOfSearch;
    @SerializedName("isError")
    @Expose
    private boolean isError;
    @SerializedName("styleId")
    @Expose
    private String styleId;
    @SerializedName("bonusData")
    @Expose
    private String bonusData;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("musician")
    @Expose
    private String musician;
    @SerializedName("md5")
    @Expose
    private String md5;
    @SerializedName("style")
    @Expose
    private Style style;

    public List<Singer> getSingers() {
        return singers;
    }

    public void setSingers(List<Singer> singers) {
        this.singers = singers;
    }

    public String getFileDownload() {
        return fileDownload;
    }

    public void setFileDownload(String fileDownload) {
        this.fileDownload = fileDownload;
    }

    public int getSearchResultId() {
        return searchResultId;
    }

    public void setSearchResultId(int searchResultId) {
        this.searchResultId = searchResultId;
    }

    public boolean isIsDuet() {
        return isDuet;
    }

    public void setIsDuet(boolean isDuet) {
        this.isDuet = isDuet;
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

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSingerId() {
        return singerId;
    }

    public void setSingerId(String singerId) {
        this.singerId = singerId;
    }

    public String getDownloadEndpoint() {
        return downloadEndpoint;
    }

    public void setDownloadEndpoint(String downloadEndpoint) {
        this.downloadEndpoint = downloadEndpoint;
    }

    public String getNameOfSearch() {
        return nameOfSearch;
    }

    public void setNameOfSearch(String nameOfSearch) {
        this.nameOfSearch = nameOfSearch;
    }

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getBonusData() {
        return bonusData;
    }

    public void setBonusData(String bonusData) {
        this.bonusData = bonusData;
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

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }
}
