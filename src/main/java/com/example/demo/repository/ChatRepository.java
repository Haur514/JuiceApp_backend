package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ChatEntity;

public interface ChatRepository extends JpaRepository<ChatEntity, Integer>{
    // public List<ChatEntity> findAll();
}
