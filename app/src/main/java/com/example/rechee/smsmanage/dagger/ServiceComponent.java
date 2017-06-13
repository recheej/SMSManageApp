package com.example.rechee.smsmanage.dagger;

import com.example.rechee.smsmanage.http.interfaces.toggl.TimeEntryService;
import com.example.rechee.smsmanage.presenters.MainPresenter;

import dagger.Component;

/**
 * Created by Rechee on 6/11/2017.
 */

@Component(modules = {ServiceModule.class, ContextModule.class})
public interface ServiceComponent {
    void injectPresenter (MainPresenter presenter);
}
