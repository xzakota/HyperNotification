package com.xzakota.hyper.notification.focus;

import com.xzakota.BaseTestCallback;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BaseTestCallback.class)
public class FocusNotificationJTest {
    @Test
    public void paramV2Test() {
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
    }

    @Test
    void paramV3Test() {
        var config = FocusNotification.createV3(template -> {
            template.setTicker("Ticker");
            template.setEnableFloat(true);
            template.setIslandFirstFloat(false);

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

            template.island(island -> {
                island.setIslandProperty(1);
                island.bigIslandArea(area -> {
                    area.imageTextInfoLeft(info -> {
                        info.setType(1);
                        info.picInfo(picInfo -> {
                            picInfo.setType(1);
                        });
                    });
                });
            });

            template.actions(list -> {
                template.addActionInfo(list, info -> {
                    info.setActionIcon("miui.focus.placeholder");
                });
            });
        });

        System.out.println(config);
    }
}
