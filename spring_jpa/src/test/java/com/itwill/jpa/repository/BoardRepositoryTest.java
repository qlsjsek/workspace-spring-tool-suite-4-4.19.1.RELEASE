package com.itwill.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.entity.Board;

@EnableJpaRepositories
class BoardRepositoryTest extends SpringJpaApplicationTests {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Test
	@Disabled
	void board_select() {
		List<Board> boardList = boardRepository.findAll();
		for (Board tempBoard : boardList) {
			System.out.println(tempBoard);
		}
		boardList = boardRepository.findByBoardnoGreaterThanEqualOrderByGroupnoDescStepAsc(0L);
		for (Board tempBoard : boardList) {
			System.out.println(tempBoard);
		}
	}
	@Test
	void board_select_page() {
		List<Board> boardList = boardRepository.findAll();
		System.out.println(">>>boardList.size() :"+boardList.size());
		/*
		 << Pageable 인터페이스에는 다음과 같은 주요 메서드와 속성이 있습니다. >>
			int getPageNumber(): 현재 페이지 번호를 반환합니다. 페이지 번호는 0부터 시작합니다.
			int getPageSize(): 한 페이지에 표시될 항목 수를 반환합니다.
			int getOffset(): 현재 페이지의 시작 오프셋을 반환합니다. 시작 오프셋은 0부터 시작합니다.
			Sort getSort(): 정렬 정보를 반환합니다. 이를 통해 페이지의 결과를 원하는 방식으로 정렬할 수 있습니다.
			Pageable next(): 다음 페이지로 이동하기 위한 Pageable 객체를 반환합니다. 이를 사용하여 다음 페이지의 데이터를 검색할 수 있습니다.
			Pageable previousOrFirst(): 이전 페이지로 이동하거나 첫 번째 페이지로 이동하기 위한 Pageable 객체를 반환합니다.
			Pageable first(): 첫 번째 페이지로 이동하기 위한 Pageable 객체를 반환합니다.
			boolean hasPrevious(): 이전 페이지가 있는지 여부를 확인하는 데 사용됩니다
		 */
		int currentPage=5; //현재페이지
		int size=10; //페이지당게시물
		
		
		Pageable pageable = PageRequest.of(0, 10,
												Sort.by("groupno").descending()
												.and(Sort.by("Step").ascending())
												);
		Page<Board> page = boardRepository.findAll(pageable);
		for (Board board : page.getContent()) {
			System.out.println(board);
		}
		/*
		<< Page 객체에는 다음과 같은 주요 메서드 및 속성이 포함되어 있습니다. >>
		- Page 객체는 주로 데이터베이스 쿼리 결과의 한 페이지를 나타내며, 페이징된 데이터를 관리하고 검색 결과를 페이지별로 표시하는 데 사용됩니다.
		
		getContent(): 현재 페이지의 데이터를 나타내는 리스트나 컬렉션을 반환합니다.
		getNumber(): 현재 페이지 번호를 반환합니다. 페이지 번호는 0부터 시작합니다.
		getSize(): 한 페이지에 표시될 항목 수를 반환합니다.
		getTotalElements(): 전체 항목 수를 반환합니다. 이 값은 페이지네이션을 사용하여 검색된 항목의 총 수를 나타냅니다.
		getTotalPages(): 전체 페이지 수를 반환합니다. 페이지 수는 페이지당 항목 수와 전체 항목 수에 따라 결정됩니다.
		hasContent(): 페이지에 내용이 있는지 여부를 확인합니다.
		isEmpty(): 페이지가 비어 있는지 여부를 확인합니다.
		isFirst(): 현재 페이지가 첫 번째 페이지인지 여부를 확인합니다.
		isLast(): 현재 페이지가 마지막 페이지인지 여부를 확인합니다.
		hasNext(): 다음 페이지가 있는지 여부를 확인합니다.
		hasPrevious(): 이전 페이지가 있는지 여부를 확인합니다.
		getPageable(): 페이지네이션 및 정렬 정보가 포함된 Pageable 객체를 반환합니다.
		*/
		System.out.println("*******************결과***********************");
		System.out.println("현재 페이지 번호	      				 :"+page.getNumber());
		System.out.println("한 페이지에 표시될 항목 수  			 :"+page.getSize());
		System.out.println("전체 항목 수            				 :"+page.getTotalElements());
		System.out.println("전체 페이지 수		     				 :"+page.getTotalPages());

		System.out.println("현재 페이지가 첫 번째 페이지인지 여부 	 :"+page.isFirst());
		System.out.println("현재 페이지가 마지막 페이지인지 여부  	 :"+page.isLast());
		System.out.println("다음 페이지가 있는지 여부         		 :"+page.hasNext());
		System.out.println("이전 페이지가 있는지 여부         		 :"+page.hasPrevious());
		Pageable currentPageable = page.getPageable();
		System.out.println("페이지시작게시물 offset[0 base index] :"+currentPageable.getOffset());
		System.out.println("페이지  끝게시물 offset[0 base index] :");
		System.out.println("페이지네이션 및 정렬 정보가 포함된 Pageable 객체를 반환:"+currentPageable.next());
		System.out.println("페이지네이션 및 정렬 정보가 포함된 Pageable 객체를 반환:"+currentPageable.next().next());
		System.out.println("페이지네이션 및 정렬 정보가 포함된 Pageable 객체를 반환:"+currentPageable.next().next().next());
		
		//페이지블록페이지수
		int BLOCK_SCALE=5;
		//현재페이지블록번호
		int curBlock=(int)Math.ceil(page.getNumber()/BLOCK_SCALE)+1;
		//페이지블록시작번호
		int blockBegin = (curBlock-1)*BLOCK_SCALE+1;
		//페이지블록끝번호
		int blockEnd = blockBegin+BLOCK_SCALE-1;
		//이전그룹시작페이지번호
		int previousGroupStartPage = blockBegin-BLOCK_SCALE;
		//다음그룹시작페이지번호
		int nextGroupStartPage = blockBegin+BLOCK_SCALE;
		System.out.println("페이지블록페이지수:"+BLOCK_SCALE);
		System.out.println("현재페이지블록번호:"+curBlock);
		System.out.println("페이지블록시작번호:"+blockBegin);
		System.out.println("페이지블록끝번호:"+blockEnd);
		System.out.println("이전그룹시작페이지번호:"+previousGroupStartPage);
		System.out.println("다음그룹시작페이지번호:"+nextGroupStartPage);
	}
	
	
	@Test
	@Disabled
	void new_save() {
		Board board1=Board.builder()
							.title("게시판101")
							.content("내용101")
							.writer("김경호101")
							.build();
		Board saveBoard1 = boardRepository.save(board1);
		saveBoard1.setGroupno(saveBoard1.getBoardno());
		saveBoard1.setStep(1L);
		saveBoard1.setDepth(0L);
		saveBoard1.setReadcount(0L);
		saveBoard1=boardRepository.save(saveBoard1);
		System.out.println(saveBoard1);

		Board board2=Board.builder()
				.title("게시판102")
				.content("내용102")
				.writer("김경호102")
				.build();
		Board saveBoard2 = boardRepository.save(board2);
		saveBoard2.setGroupno(saveBoard2.getBoardno());
		saveBoard2.setStep(2L);
		saveBoard2.setDepth(0L);
		saveBoard2.setReadcount(0L);
		saveBoard2=boardRepository.save(saveBoard2);
		System.out.println(saveBoard2);
	}
	
	@Test
	@Disabled
	void reply_save() {
		
		Board findBoard100 = boardRepository.findById(100L).get();
		List<Board> updateBoardList100 = boardRepository.findByStepGreaterThanAndGroupno(findBoard100.getStep(), findBoard100.getGroupno());
		for (Board tempBoard : updateBoardList100) {
			tempBoard.setStep(tempBoard.getStep()+1);
		}
		boardRepository.saveAll(updateBoardList100);
		
		Board board101 = Board.builder()
								.title("게시판타이틀101")
								.content("내용101")
								.writer("김경호101")
								.groupno(findBoard100.getGroupno())
								.step(findBoard100.getStep()+1)
								.depth(findBoard100.getDepth()+1)
								.build();
		boardRepository.save(board101);
		
	}
	
	
	
}
