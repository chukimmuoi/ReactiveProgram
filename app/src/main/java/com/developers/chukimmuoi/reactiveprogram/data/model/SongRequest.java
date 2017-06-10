package com.developers.chukimmuoi.reactiveprogram.data.model;

import com.developers.chukimmuoi.reactiveprogram.constants.IConstants;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import static com.developers.chukimmuoi.reactiveprogram.constants.IConstants.DEVICE_ID_PARAM;
import static com.developers.chukimmuoi.reactiveprogram.constants.IConstants.LAST_UPDATE_PARAM;
import static com.developers.chukimmuoi.reactiveprogram.constants.IConstants.NUMBER_PARAM;
import static com.developers.chukimmuoi.reactiveprogram.constants.IConstants.PAGE_PARAM;
import static com.developers.chukimmuoi.reactiveprogram.constants.IConstants.SIGN_PARAM;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : ReactiveProgram
 * Created by chukimmuoi on 6/10/17.
 */

public class SongRequest {

    private String id;

    private int number;

    private int page;

    private long lastUpdate;

    private String sign;

    @Inject
    public SongRequest() {
        this.id         = IConstants.DEVICE_ID_VALUES;
        this.number     = IConstants.NUMBER_50_VALUES;
        this.page       = IConstants.PAGE_VALUES;
        this.lastUpdate = IConstants.LAST_UPDATE_VALUES;
        this.sign       = IConstants.SIGN_50_VALUES;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Map<String, String> convertToMap() {
        Map<String, String> map = new HashMap<>();

        map.put(DEVICE_ID_PARAM, this.id);
        map.put(NUMBER_PARAM, String.valueOf(this.number));
        map.put(PAGE_PARAM, String.valueOf(this.page));
        map.put(LAST_UPDATE_PARAM, String.valueOf(this.lastUpdate));
        map.put(SIGN_PARAM, this.sign);

        return map;
    }
}
