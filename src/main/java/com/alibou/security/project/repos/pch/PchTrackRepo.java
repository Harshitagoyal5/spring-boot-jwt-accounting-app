package com.alibou.security.project.repos.pch;
import com.alibou.security.project.entity.pch.PchTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PchTrackRepo extends JpaRepository<PchTrack, Long> {

}
