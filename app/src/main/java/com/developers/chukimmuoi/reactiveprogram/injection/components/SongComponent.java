package com.developers.chukimmuoi.reactiveprogram.injection.components;

import com.developers.chukimmuoi.reactiveprogram.MainActivity;
import com.developers.chukimmuoi.reactiveprogram.injection.UserScope;
import com.developers.chukimmuoi.reactiveprogram.injection.modules.SongModule;

import dagger.Component;

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
 * Mối quan hệ cha con Dependent Components vs Sub Components
 * Cha (Subcomponents): NetComponent
 * Con (Dependent Components): SongModule
 *
 * Sử dụng @UserScope: Xác định phạm vi, là cần thiết khi sử dụng Sub Components
 * Khi sử dụng Scope: @Singleton sẽ bị vô hiệu.
 * */
@UserScope
@Component(dependencies = NetComponent.class, modules = SongModule.class)
public interface SongComponent {
    void inject(MainActivity activity);
}
