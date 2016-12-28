package receive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import receive.dao.ReceiveDAO;
import receive.model.ReceiveDataBean;

@Controller
public class ReceiveServiceImpl implements ReceiveService {
 
	@Autowired
	private ReceiveDAO dao;

	public void setDao(ReceiveDAO dao) {
		this.dao = dao;
	}

	// ���� ���
	@Override
	public List<Object> getReceives(int startRow, int endRow, String m_email) {
		List<Object> list = null;

		list = dao.getReceives(startRow, endRow, m_email);

		return list;
	}

	// ��ü ���� ����
	@Override
	public int getReceiveCount(String m_email) { 
		int count = 0;
		count = dao.getReceiveCount(m_email);
		return count;
	}
	// ���� Ŭ�� �� ����
	@Override
	public ReceiveDataBean getReceive(int rm_id) {
		ReceiveDataBean list = null;
		System.out.println(rm_id);
		try { // city�� mepper������ id���� �ش��Ѵ�.
			list = dao.getReceive(rm_id);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	// �������� ���� ��
	@Override
	public int unCheckedCount() {
		int count = 0; // �˻� ��� ����

		count = dao.unChcekedCount();

		return count;
	}  

	// ���� ����
	@Override
	public int delete(int rm_id, int[] arry) {
		int check;
		
		for(check == 1)
		

	}
}
