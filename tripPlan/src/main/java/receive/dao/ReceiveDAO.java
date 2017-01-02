package receive.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import receive.model.ReceiveDataBean;


public class ReceiveDAO extends SqlSessionDaoSupport {

	// �����ٿ� ���� ���̿� �ִ� �� ����� �������� method 
	public List<Object> getReceives(int startRow, int endRow, String m_email) {
		// int�� �����͸� string���� ����ϱ� ���ؼ� map��ü�� �����Ѵ� 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("m_email", m_email);
		// selectList()�� sql���� startRow, endRow�� ���� map��ü�� ���� ������ ó���Ѵ�.
		List<Object> getReceives = getSqlSession().selectList("letter.getList", map);
		return getReceives;
	}
	
	// ��ü ���� ����
	public int getReceiveCount(String m_email) {
		int count = getSqlSession().selectOne("letter.getReceiveCount", m_email);
		return count;
	}
	// ���� �� ���� 
	public ReceiveDataBean getReceive(int rm_id) {
		ReceiveDataBean getReceive = getSqlSession().selectOne("letter.getReceive", rm_id);
		return getReceive;
	}
	// ����Ȯ��
	public void updateCheck(int rm_id) {
		getSqlSession().update("letter.updateCheck", rm_id);
		
	}
	// ����Ȯ��2
	public void updateCheck2(int rm_id) {
		getSqlSession().update("letter.updateCheck2", rm_id);
	}
	
	// �������� ���� �� ��� 
	public int unChcekedCount() {
		int uncheck = getSqlSession().selectOne("letter.unCheck");
		
		return uncheck; 
	}
	
	// ���� ���� ���� 
	public void receivedelete(ReceiveDataBean receiveDB) {
		String[] strList = receiveDB.getChk().split(",");
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> chkList = new ArrayList<String>();
		String m_email = receiveDB.getM_email();
		for (int i=0; i<strList.length; i++) {
			chkList.add(strList[i]);
		} 
		map.put("chkList", chkList);
		map.put("m_email", m_email);
		getSqlSession().delete("letter.receivedelete", map);
	}
}

