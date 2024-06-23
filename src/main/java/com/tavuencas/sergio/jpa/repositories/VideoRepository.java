package com.tavuencas.sergio.jpa.repositories;

import com.tavuencas.sergio.jpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
