package send.service;

import java.util.List;

import send.dao.SendDataBean;

public interface SendService {
	
	// ���� ���� 
	public int insert(SendDataBean send);
	// ��ü ���� ����
	public int getSendCount(String m_email);
	// ���� ������ ��� 
	public List<Object> getSends(int startRow,int endRow, String m_email);
	// ���� ���� �� ���� 
	public SendDataBean getSend(int sm_id);
	//  �ǽð� ���̵� üũ
	public List<String> realTimeIdchk();
	//  �ǽð� ���̵� üũ2
	public int realTimeIdchk2(String sm_receiver);
	
}
