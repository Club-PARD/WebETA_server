package com.hyunseung.webETA.service;

import com.hyunseung.webETA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired UserRepository userRepository;

}
