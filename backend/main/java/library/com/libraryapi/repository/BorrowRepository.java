package library.com.libraryapi.repository;

import library.com.libraryapi.domain.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> { }