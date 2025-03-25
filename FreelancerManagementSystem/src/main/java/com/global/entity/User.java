package com.global.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "app_user") 
@Getter
@Setter
public class User extends BaseUser {
    private String phoneNumber;
}