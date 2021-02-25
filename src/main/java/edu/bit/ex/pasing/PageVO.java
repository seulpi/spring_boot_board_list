package edu.bit.ex.pasing;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class PageVO {
	
	private int startPage, endPage, total;
	private boolean next, prev;
	
	private Criteria criteria;
	
	public PageVO(int total, Criteria cri) { // 나누기 안하고 cri.getPageNum()*0.1 해도 같음
		this.total = total;
		this.criteria = cri;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage = this.endPage -9;
		
		
		int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realEnd <= this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	
	}
	
	public String makeQuery(int pageNum) {
		UriComponents components = UriComponentsBuilder.newInstance().queryParam("pageNum", pageNum).queryParam("amount", criteria.getAmount()).build();
		
		return components.toString();
	}
}
