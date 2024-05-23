package com.cloudpos.one2two;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;


public class AidlMgr {

    private static AidlMgr instance;

    private AidlMgr() {
    }

    public static AidlMgr getInstance() {
        if (instance == null) {
            instance = new AidlMgr();
        }
        return instance;
    }

    public boolean startSystemExtApiService(Context host, ServiceConnection connection) {
        ComponentName comp = new ComponentName(
                "com.wizarpos.wizarviewagentassistant",
                "com.wizarpos.wizarviewagentassistant.SystemExtApiService");
        boolean isSuccess = startConnectService(host, comp, connection);
        return isSuccess;
    }

    protected boolean startConnectService(Context host, ComponentName comp, ServiceConnection connection) {
        Intent intent = new Intent();
        intent.setComponent(comp);
        boolean isSuccess = host.bindService(intent, connection, Context.BIND_AUTO_CREATE);
        host.startService(intent);
        return isSuccess;
    }

}
