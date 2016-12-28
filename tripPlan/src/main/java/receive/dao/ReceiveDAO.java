<<<<<<< HEAD
package receive.dao;

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
	
	// �������� ���� �� ��� 
	public int unChcekedCount() {
		int uncheck = getSqlSession().selectOne("letter.unCheck");
		
		return uncheck; 
	}
	
	// ���� ���� ���� 
	public void delete(int[] rm_id) {
		getSqlSession().delete("letter.delete", rm_id);
	}
}
=======
package receive.dao;

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
	
	// �������� ���� �� ��� 
	public int unChcekedCount() {
		int uncheck = getSqlSession().selectOne("letter.unCheck");
		
		return uncheck; 
	}
	
	// ���� ���� ���� 
	public void delete(int[] rm_id, int[] arry) {
		getSqlSession().delete("letter.delete", rm_id);
	}


}
>>>>>>> refs/heads/dohun
