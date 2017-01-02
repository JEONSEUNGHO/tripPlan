package receive.service;

import java.util.List;
import org.springframework.stereotype.Controller;
import receive.model.ReceiveDataBean;

@Controller
public interface ReceiveService {
	
	// ���� ��� 
	public List<Object> getReceives(int startRow,int endRow, String m_email);
	// ��ü ���� ����
	public int getReceiveCount(String m_email);
	// ���� Ŭ�� �� ����
	public ReceiveDataBean getReceive(int rm_id);
	// �������� ���� �� 
	public int unCheckedCount();
	// ���� ���� 
	public void receivedelete(ReceiveDataBean receiveDB);

}
