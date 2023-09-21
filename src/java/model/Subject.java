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
public class Subject {
    private int subject_id;
    private int manager_id;
    private String subject_name;
    private String subject_code;
    private String description;
    private String img_url;
    private boolean status;
    private Date create_at;
    private int create_by;
    private Date update_at;
    private int update_by;

    public Subject() {
    }

    public Subject(int subject_id, int manager_id, String subject_name, String subject_code, String description, String img_url, boolean status, Date create_at, int create_by, Date update_at, int update_by) {
        this.subject_id = subject_id;
        this.manager_id = manager_id;
        this.subject_name = subject_name;
        this.subject_code = subject_code;
        this.description = description;
        this.img_url = img_url;
        this.status = status;
        this.create_at = create_at;
        this.create_by = create_by;
        this.update_at = update_at;
        this.update_by = update_by;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public int getCreate_by() {
        return create_by;
    }

    public void setCreate_by(int create_by) {
        this.create_by = create_by;
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
