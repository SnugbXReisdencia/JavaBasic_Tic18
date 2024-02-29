package com.EverDev.Leilao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EverDev.Leilao.model.Lance;

public interface LanceRespository extends JpaRepository<Lance, Long> {

	List<Lance> findByLeilaoId(Long idLeilao);
}
