package com.example.binoypaul.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

  public int MyServiceTrialMethod(int a, int b)
    {
        return (a+b);
    }

    @Override
    public IBinder onBind(Intent intent) {
   //    return BinoBind;
            return null;
    }



}
