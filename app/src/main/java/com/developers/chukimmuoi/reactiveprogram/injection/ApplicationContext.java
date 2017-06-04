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
 * <==>@Named("application_context")</==>
 * */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {

}
