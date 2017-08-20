package com.samih.abs.samihtaskmng2017.data;

import java.util.HashMap;

/**
 * Created by samih on 11/07/2017.
 */

public class MyUser
{

    private String name;
    private String uKey_email;//key
    private String phone;
    private HashMap<String,Object> groupsKeys =new HashMap<>();
    private HashMap<String,Object> tasksKeys=new HashMap<>();

    public MyUser() {
    }

    public void setGroupsKeys(HashMap<String, Object> groupsKeys) {
        this.groupsKeys = groupsKeys;
    }

    public void setTasksKeys(HashMap<String, Object> tasksKeys) {
        this.tasksKeys = tasksKeys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getuKey_email() {
        return uKey_email.replace('.','*');
    }
    public String getEmail() {
        return uKey_email;
    }
    public void setuKey_email(String uKey_email) {
        this.uKey_email = uKey_email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public HashMap<String, Object> getGroupsKeys() {
        return groupsKeys;
    }

    public HashMap<String, Object> getTasksKeys() {
        return tasksKeys;
    }

    public void addTasksKey(String taskKey) {
        this.tasksKeys.put(taskKey,true);
    }
    public void addGruopsKeys(String gruopKey)
    {
        this.groupsKeys.put(gruopKey,true);
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "name='" + name + '\'' +
                ", email='" + uKey_email + '\'' +
                ", phone='" + phone + '\'' +
                ", gruopsIDs=" + groupsKeys +
                ", tasksIDs=" + tasksKeys +
                '}';
    }
}
