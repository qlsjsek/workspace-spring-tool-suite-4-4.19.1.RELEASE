package com.itwill.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.itwill.jpa.SpringBootJpaApplicationTests;
import com.itwill.jpa.entity.Board;


class BoardRepositoryTest extends SpringBootJpaApplicationTests{
	@Autowired
	BoardRepository boardRepository;
	@Test
	void board_crud(){
		/*
		Board board1=new Board(0L,"게시판201", "김경호1", "내용1",LocalDateTime.now(),0L,0L,0L,0L);
		Board board2=new Board(0L,"게시판202", "김경호1", "내용1",LocalDateTime.now(),0L,0L,0L,0L);
		
		Board board1=new Board("게시판201", "김경호1", "내용1");
		Board board2=new Board("게시판202", "김경호1", "내용1");
		Board saveBoard1= boardRepository.save(board1);
		Board saveBoard2= boardRepository.save(board2);
		System.out.println(">>> saveBoard1:"+saveBoard1);
		System.out.println(">>> saveBoard2:"+saveBoard2);
		System.out.println(boardRepository.findById(1L).get());
		*/
	}
	@Test
	void board_select() {
		/*
		Board board1=new Board(0L,"게시판201", "김경호1", "내용1",LocalDateTime.now(),0L,0L,0L,0L);
		Board board2=new Board(0L,"게시판202", "김경호1", "내용1",LocalDateTime.now(),0L,0L,0L,0L);
		
		Board board1=new Board("게시판201", "김경호1", "내용1");
		Board board2=new Board("게시판202", "김경호1", "내용1");
		Board saveBoard1= boardRepository.save(board1);
		Board saveBoard2= boardRepository.save(board2);
		System.out.println(">>> saveBoard1:"+saveBoard1);
		System.out.println(">>> saveBoard2:"+saveBoard2);
		System.out.println(">>> findById:"+boardRepository.findById(1L).get());
		*/
	}
	@Test
	void board_select_pagable() {
		
	}
	

}
