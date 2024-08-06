package kosa.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosa.mapper.BoardMapper;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	// 글 작성하기
	public void insertBoard(Board board) {
		sqlTemplate.getMapper(BoardMapper.class).insertBoard(board);
	}
	
	// 글 목록 가져오기
	public List<Board>listBoard() {
		return sqlTemplate.getMapper(BoardMapper.class).listBoard();
	}
	
	// 글 상세 목록 가져오기
	public Board detailBoard(int seq) {
		return sqlTemplate.getMapper(BoardMapper.class).detailBoard(seq);
	}
	
}
