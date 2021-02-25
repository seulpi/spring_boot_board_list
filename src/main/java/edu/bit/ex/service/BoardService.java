package edu.bit.ex.service;

import java.util.List;

import edu.bit.ex.pasing.Criteria;
import edu.bit.ex.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> getList();

	public  List<BoardVO> getPageList(Criteria cri);

	public int getTotal(Criteria cri);

	public void writeAdd(BoardVO vo);
	
	//content_view List<>타입으로 받아서 jsp에서 forEach사용
	//Lis<> 타입은 <c:forEach>문으로 받아야 NumberException 에러가 나지않는다
	public List<BoardVO> getContent(int getbId);

	public void delete(int getbId);

	public void modify(BoardVO vo);

	public void replyAdd(BoardVO vo); 
	

}
