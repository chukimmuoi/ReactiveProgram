package com.developers.chukimmuoi.reactiveprogram.injection;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : ReactiveProgram
 * Created by chukimmuoi on 6/4/17.
 */

/**
 * <==>@Named("activity_context")</==>
 *
 * @Qualifier: dùng để phân biệt các đối tượng cùng loại nhưng mục đích sử dụng khác nhau.
 * */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityContext {

}
