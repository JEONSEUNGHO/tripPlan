package send.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SendDAO extends SqlSessionDaoSupport {
	
	public int insert(String string, SendDataBean send) {
		int check = getSqlSession().insert(string, send);
		return check;
	}
	public List<Object> getSends(int startRow, int endRow, String m_email) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("m_email", m_email);
		List<Object> getSends = getSqlSession().selectList("letter.getSends", map);
		return getSends;
	}
	
	// ��ü ���� ����
	public int getSendCount(String m_email) {
		int count = getSqlSession().selectOne("letter.getSendCount", m_email);
		return count;
	}

	// ���� ���� �󼼳���
	public SendDataBean getSend(int sm_id) {
		SendDataBean getSend = getSqlSession().selectOne("letter.getSend", sm_id);
		return getSend;
	}
	
	// �������� �ǽð� ���̵� üũ
	public List<String> realTimeIdchk() {

		List<String> resultList =  getSqlSession().selectList("letter.realtimeidchk");
		
		return resultList;
	}
}
