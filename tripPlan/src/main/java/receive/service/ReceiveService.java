package receive.service;

import java.util.List;
import org.springframework.stereotype.Controller;
import receive.model.ReceiveDataBean;

@Controller
public interface ReceiveService {
	
	// 쪽지 목록 
	public List<Object> getReceives(int startRow,int endRow, String m_email);
	// 전체 쪽지 개수
	public int getReceiveCount(String m_email);
	// 쪽지 클릭 시 내용
	public ReceiveDataBean getReceive(int rm_id);
	// 읽지않은 쪽지 수 
	public int unCheckedCount();
	// 쪽지 삭제 
	public void receivedelete(ReceiveDataBean receiveDB);

}
