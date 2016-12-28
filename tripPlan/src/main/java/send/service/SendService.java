package send.service;

import java.util.List;

import send.dao.SendDataBean;

public interface SendService {
	
	// 쪽지 쓰기 
	public int insert(SendDataBean send);
	// 전체 쪽지 개수
	public int getSendCount(String m_email);
	// 보낸 쪽지함 목록 
	public List<Object> getSends(int startRow,int endRow, String m_email);
	// 보낸 쪽지 상세 정보 
	public SendDataBean getSend(int sm_id);
	//  실시간 아이디 체크
	public List<String> realTimeIdchk();
	//  실시간 아이디 체크2
	public int realTimeIdchk2(String sm_receiver);
	
}
