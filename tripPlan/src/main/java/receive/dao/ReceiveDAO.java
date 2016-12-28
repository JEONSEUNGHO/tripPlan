<<<<<<< HEAD
package receive.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import receive.model.ReceiveDataBean;


public class ReceiveDAO extends SqlSessionDaoSupport {

	// 시작줄와 끝줄 사이에 있는 글 목록을 가져오는 method 
	public List<Object> getReceives(int startRow, int endRow, String m_email) {
		// int형 데이터를 string으로 사용하기 위해서 map객체에 저장한다 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("m_email", m_email);
		// selectList()에 sql문과 startRow, endRow를 담은 map객체도 같이 보내서 처리한다.
		List<Object> getReceives = getSqlSession().selectList("letter.getList", map);
		return getReceives;
	}
	
	// 전체 쪽지 개수
	public int getReceiveCount(String m_email) {
		int count = getSqlSession().selectOne("letter.getReceiveCount", m_email);
		return count;
	}
	// 쪽지 상세 내용 
	public ReceiveDataBean getReceive(int rm_id) {
		ReceiveDataBean getReceive = getSqlSession().selectOne("letter.getReceive", rm_id);
		return getReceive;
	}
	
	// 읽지않은 쪽지 수 출력 
	public int unChcekedCount() {
		int uncheck = getSqlSession().selectOne("letter.unCheck");
		
		return uncheck; 
	}
	
	// 선택 쪽지 삭제 
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

	// 시작줄와 끝줄 사이에 있는 글 목록을 가져오는 method 
	public List<Object> getReceives(int startRow, int endRow, String m_email) {
		// int형 데이터를 string으로 사용하기 위해서 map객체에 저장한다 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("m_email", m_email);
		// selectList()에 sql문과 startRow, endRow를 담은 map객체도 같이 보내서 처리한다.
		List<Object> getReceives = getSqlSession().selectList("letter.getList", map);
		return getReceives;
	}
	
	// 전체 쪽지 개수
	public int getReceiveCount(String m_email) {
		int count = getSqlSession().selectOne("letter.getReceiveCount", m_email);
		return count;
	}
	// 쪽지 상세 내용 
	public ReceiveDataBean getReceive(int rm_id) {
		ReceiveDataBean getReceive = getSqlSession().selectOne("letter.getReceive", rm_id);
		return getReceive;
	}
	
	// 읽지않은 쪽지 수 출력 
	public int unChcekedCount() {
		int uncheck = getSqlSession().selectOne("letter.unCheck");
		
		return uncheck; 
	}
	
	// 선택 쪽지 삭제 
	public void delete(int[] rm_id, int[] arry) {
		getSqlSession().delete("letter.delete", rm_id);
	}


}
>>>>>>> refs/heads/dohun
