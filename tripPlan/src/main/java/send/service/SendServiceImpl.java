package send.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import send.dao.SendDAO;
import send.dao.SendDataBean;

@Controller
public class SendServiceImpl implements SendService {

	@Autowired
	private SendDAO senddao;

	public void setDao(SendDAO senddao) {
		this.senddao = senddao;
	}

	@Override
	// 쪽지 쓰기
	public int insert(SendDataBean send) {
		int check = 0;

		check = senddao.insert("letter.insert", send);
 
		return check;

	}

	@Override
	// 쪽지 전체 개수
	public int getSendCount(String m_email) {
		int count = 0;
		count = senddao.getSendCount(m_email);
		return count;
	}

	@Override
	// 보낸 쪽지 목록
	public List<Object> getSends(int startRow, int endRow, String m_email) {
		List<Object> list = null;
		list = senddao.getSends(startRow, endRow, m_email);

		return list;
	}

	@Override
	// 보낸 쪽지 상세 정보
	public SendDataBean getSend(int sm_id) {

		SendDataBean list = null;
		list = senddao.getSend(sm_id);

		return list;

	}
	
	// 실시간 아이디 체크
	@Override
	public List<String> realTimeIdchk() {
		
		List<String> resultList = senddao.realTimeIdchk();
		return resultList;
	}
	
	// 실시간 아이디 체크2
	@Override
	public int realTimeIdchk2(String sm_receiver) {
		 
		int check = senddao.realTimeIdchk2(sm_receiver);
		return check;
	}

}
