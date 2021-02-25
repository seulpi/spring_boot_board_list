package edu.bit.ex.service;

import java.util.List;

import edu.bit.ex.pasing.Criteria;
import edu.bit.ex.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> getList();

	public  List<BoardVO> getPageList(Criteria cri);

	public int getTotal(Criteria cri);
	

}
