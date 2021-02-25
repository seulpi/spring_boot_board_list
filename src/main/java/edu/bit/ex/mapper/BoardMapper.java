package edu.bit.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.ex.pasing.Criteria;
import edu.bit.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {

	List<BoardVO> getList();

	List<BoardVO> getPageList(Criteria cri);

	int getPageTotal(Criteria cri);

	void writeAdd(BoardVO vo);

	List<BoardVO> getContentView(int getbId);

	void delete(int getbId);

	void modify(BoardVO vo);

	void replyAdd(BoardVO vo);

	void replySort(BoardVO vo);
	
	

}
