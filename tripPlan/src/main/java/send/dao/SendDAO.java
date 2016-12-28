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
	
	// 전체 쪽지 개수
	public int getSendCount(String m_email) {
		int count = getSqlSession().selectOne("letter.getSendCount", m_email);
		return count;
	}

	// 보낸 쪽지 상세내용
	public SendDataBean getSend(int sm_id) {
		SendDataBean getSend = getSqlSession().selectOne("letter.getSend", sm_id);
		return getSend;
	}
	
	// 쪽지쓰기 실시간 아이디 체크
	public List<String> realTimeIdchk() {

		List<String> resultList =  getSqlSession().selectList("letter.realtimeidchk");
		
		return resultList;
	}
}
