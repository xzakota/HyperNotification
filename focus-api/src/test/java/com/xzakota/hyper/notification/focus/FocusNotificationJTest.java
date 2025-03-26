package com.xzakota.hyper.notification.focus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FocusNotificationJTest {
    @Test
    void paramV2Test() {
        var config = FocusNotification.createV2(template -> {
            template.setTicker("Ticker");
            template.setEnableFloat(true);

            template.baseInfo(info -> {
                info.setType(1);
                info.setTitle("Title1");
                info.setContent("Content1");
            });

            template.hintInfo(info -> {
                info.setType(1);
                info.setTitle("Title2");
                info.setContent("Content2");
            });

            template.actions(list -> {
                template.addActionInfo(list, info -> {
                    info.setActionIcon("miui.focus.placeholder");
                });
            });
        });

        System.out.println(config);
        Assertions.assertNotNull(config);
    }
}
