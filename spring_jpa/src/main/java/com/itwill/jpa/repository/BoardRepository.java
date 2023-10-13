package com.itwill.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	List<Board> findByStepGreaterThanAndGroupno(Long step,Long groupNo);
	List<Board> findByBoardnoGreaterThanEqualOrderByGroupnoDescStepAsc(Long boardNo);
	//List<Board> findByBoardnoGreaterThanEqualOrderByGroupnoDescStepAsc(Long boardNo,Pageable page);
}
