package com.xworkz.dao;

import com.xworkz.entity.SignInEntity;
import com.xworkz.entity.SignUpEntity;

import java.util.List;

public interface SignUpDAO {
    Boolean save(SignUpEntity signUpEntity);

    Boolean saveAll(List<SignUpEntity> sign);

    public SignUpEntity getSignEntity(Integer id);

    public SignUpEntity getSignEntity(String name);

}
