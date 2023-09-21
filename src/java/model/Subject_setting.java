/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Nết
 */
public class Subject_setting {
    private int setting_id;
    private int subject_id;
    private int setting_group;
    private String setting_name;
    private int setting_value;
    private int display_order;
    private String description;
    private Date create_by;
    private int create_at;
    private Date update_at;
    private int update_by;

    public Subject_setting() {
    }

    public Subject_setting(int setting_id, int subject_id, int setting_group, String setting_name, int setting_value, int display_order, String description, Date create_by, int create_at, Date update_at, int update_by) {
        this.setting_id = setting_id;
        this.subject_id = subject_id;
        this.setting_group = setting_group;
        this.setting_name = setting_name;
        this.setting_value = setting_value;
        this.display_order = display_order;
        this.description = description;
        this.create_by = create_by;
        this.create_at = create_at;
        this.update_at = update_at;
        this.update_by = update_by;
    }

    public int getSetting_id() {
        return setting_id;
    }

    public void setSetting_id(int setting_id) {
        this.setting_id = setting_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getSetting_group() {
        return setting_group;
    }

    public void setSetting_group(int setting_group) {
        this.setting_group = setting_group;
    }

    public String getSetting_name() {
        return setting_name;
    }

    public void setSetting_name(String setting_name) {
        this.setting_name = setting_name;
    }

    public int getSetting_value() {
        return setting_value;
    }

    public void setSetting_value(int setting_value) {
        this.setting_value = setting_value;
    }

    public int getDisplay_order() {
        return display_order;
    }

    public void setDisplay_order(int display_order) {
        this.display_order = display_order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Date create_by) {
        this.create_by = create_by;
    }

    public int getCreate_at() {
        return create_at;
    }

    public void setCreate_at(int create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public int getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(int update_by) {
        this.update_by = update_by;
    }
    
}
