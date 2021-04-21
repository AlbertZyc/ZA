package com.zyc.za.queue;

import android.util.Log;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * @Author AlbertZ
 * @CreateDate 2021/3/23
 * @Description 描述
 */
public class LogTask extends BaseTask {
    String name;

    public LogTask(String name) {
        this.name = name;
    }

    //执行任务方法，在这里实现你的任务具体内容
    @Override
    public void doTask() {
        super.doTask();
        Log.i("LogTask", "--doTask-" + name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        unLockBlock();
    }

    //任务执行完的回调，在这里你可以做些释放资源或者埋点之类的操作
    @Override
    public void finishTask() {
        super.finishTask();
        Log.i("LogTask", "--finishTask-" + name);
    }
}

