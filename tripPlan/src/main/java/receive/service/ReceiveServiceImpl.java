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

	// 쪽지 목록
	@Override
	public List<Object> getReceives(int startRow, int endRow, String m_email) {
		List<Object> list = null;

		list = dao.getReceives(startRow, endRow, m_email);

		return list;
	}

	// 전체 쪽지 개수
	@Override
	public int getReceiveCount(String m_email) { 
		int count = 0;
		count = dao.getReceiveCount(m_email);
		return count;
	}
	// 쪽지 클릭 시 내용
	@Override
	public ReceiveDataBean getReceive(int rm_id) {
		ReceiveDataBean list = null;
		System.out.println(rm_id);
		try { // city는 mepper파일의 id값에 해당한다.
			list = dao.getReceive(rm_id);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	// 읽지않은 쪽지 수
	@Override
	public int unCheckedCount() {
		int count = 0; // 검색 결과 개수

		count = dao.unChcekedCount();

		return count;
	}  

	// 쪽지 삭제
	@Override
	public int delete(int rm_id, int[] arry) {
		int check;
		
		for(check == 1)
		

	}
}
