package com.xzakota.hyper.notification.focus.example;

import com.xzakota.hyper.notification.focus.example.IPrivilegedLogCallback;

interface IPrivilegedService {
    void setLogCallback(IPrivilegedLogCallback callback);
    boolean setPackageNetworkingEnabled(int uid, boolean enabled);
}
