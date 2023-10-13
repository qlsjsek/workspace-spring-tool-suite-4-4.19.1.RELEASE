package com.itwill.jpa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long>{

	Long removeByGuestName(String guestName);
	Long countByGuestName(String guestName);
	Boolean existsByGuestName(String guestName);
	List<Guest> findByGuestNoBetween(Long guestNo1,Long guestNo2);
	List<Guest> findByGuestDateGreaterThan(Date guestDate);
	List<Guest> findByGuestDateGreaterThanEqual(Date guestDate);
}
