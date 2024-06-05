package com.example.examiasf.repository;

import com.example.examiasf.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member, String> {
}
