package com.samih.abs.samihtaskmng2017.data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by samih on 11/07/2017.
 */

public class MyGroup
{
    private String gKey;
    private String mngrUkey;
    private String name;
    private HashMap<String,Object> usersKeys=new HashMap<>();
    private HashMap<String,Object> tasksKeys=new HashMap<>();

    public MyGroup() {
    }

    public String getgKey() {
        return gKey;
    }

    public void setgKey(String gKey) {
        this.gKey = gKey;
    }

    public String getMngrUkey() {
        return mngrUkey;
    }

    public void setMngrUkey(String mngrUkey) {
        this.mngrUkey = mngrUkey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Object> getUsersKeys() {
        return usersKeys;
    }

    public void setUsersKeys(HashMap<String, Object> usersKeys) {
        this.usersKeys = usersKeys;
    }
    public void addUserKey(String ukey)
    {
        this.usersKeys.put(ukey,true);
    }

    public HashMap<String, Object> getTasksKeys() {
        return tasksKeys;
    }

    public void setTasksKeys(HashMap<String, Object> tasksKeys) {
        this.tasksKeys = tasksKeys;
    }
    public void addTaskKey(String taskKey)
    {
        this.tasksKeys.put(taskKey,true);
    }

    @Override
    public String toString() {
        return "MyGroup{" +
                "gKey='" + gKey + '\'' +
                ", mngrUkey='" + mngrUkey + '\'' +
                ", name='" + name + '\'' +
                ", usersKeys=" + usersKeys +
                ", tasksKeys=" + tasksKeys +
                '}';
    }
}
