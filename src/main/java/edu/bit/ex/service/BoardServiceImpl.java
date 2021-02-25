package edu.bit.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.pasing.Criteria;
import edu.bit.ex.vo.BoardVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList() {
		
		return mapper.getList();
	}

	@Override
	public List<BoardVO> getPageList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getPageList(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getPageTotal(cri);
	}

	@Override
	public void writeAdd(BoardVO vo) {
		mapper.writeAdd(vo);
		
	}

	@Override
	public List<BoardVO> getContent(int getbId) {
		// TODO Auto-generated method stub
		return mapper.getContentView(getbId);
	}

	@Override
	public void delete(int getbId) {
		mapper.delete(getbId);
		
	}

	@Override
	public void modify(BoardVO vo) {
		mapper.modify(vo);
	}

	@Override
	public void replyAdd(BoardVO vo) {
		mapper.replyAdd(vo);
		mapper.replySort(vo);
		
	}

	@Override
	public void upHit(int getbId) {
		mapper.upHit(getbId);
	}

}
