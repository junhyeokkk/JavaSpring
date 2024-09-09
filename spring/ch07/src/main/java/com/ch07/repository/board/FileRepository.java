package com.ch07.repository.board;

import com.ch07.entity.board.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Integer> {

}
