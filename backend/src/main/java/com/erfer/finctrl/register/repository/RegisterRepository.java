package com.erfer.finctrl.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erfer.model.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
}
