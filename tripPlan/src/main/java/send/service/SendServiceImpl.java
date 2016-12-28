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
	// ���� ����
	public int insert(SendDataBean send) {
		int check = 0;

		check = senddao.insert("letter.insert", send);
 
		return check;

	}

	@Override
	// ���� ��ü ����
	public int getSendCount(String m_email) {
		int count = 0;
		count = senddao.getSendCount(m_email);
		return count;
	}

	@Override
	// ���� ���� ���
	public List<Object> getSends(int startRow, int endRow, String m_email) {
		List<Object> list = null;
		list = senddao.getSends(startRow, endRow, m_email);

		return list;
	}

	@Override
	// ���� ���� �� ����
	public SendDataBean getSend(int sm_id) {

		SendDataBean list = null;
		list = senddao.getSend(sm_id);

		return list;

	}
	
	// �ǽð� ���̵� üũ
	@Override
	public List<String> realTimeIdchk() {
		
		List<String> resultList = senddao.realTimeIdchk();
		return resultList;
	}
	
	// �ǽð� ���̵� üũ2
	@Override
	public int realTimeIdchk2(String sm_receiver) {
		 
		int check = senddao.realTimeIdchk2(sm_receiver);
		return check;
	}

}
