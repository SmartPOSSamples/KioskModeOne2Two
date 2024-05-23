package com.cloudpos.one2two;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.wizarpos.wizarviewagentassistant.aidl.ISystemExtApi;

public class AidlControl {

    private static AidlControl instance;

    private AidlControl() {
    }

    public static AidlControl getInstance() {
        if (instance == null) {
            instance = new AidlControl();
        }
        return instance;
    }

    public void startLockTaskMode(final Context context, final int taskID) {
        ServiceConnection systemExtApiConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                ISystemExtApi systemExtApiService = ISystemExtApi.Stub.asInterface(service);
                try {
                    systemExtApiService.startLockTaskMode(taskID);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    context.unbindService(this);
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        boolean success = AidlMgr.getInstance().startSystemExtApiService(context, systemExtApiConn);
    }
}
