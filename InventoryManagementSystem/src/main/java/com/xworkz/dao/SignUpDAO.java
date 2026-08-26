package com.xworkz.dao;

import com.xworkz.entity.SignInEntity;
import com.xworkz.entity.SignUpEntity;

public interface SignUpDAO {
    Boolean save(SignUpEntity signUpEntity);
}
