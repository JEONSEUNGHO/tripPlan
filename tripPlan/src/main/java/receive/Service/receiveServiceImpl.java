package receive.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import receive.DAO.ReceiveDataBean;
import receive.DAO.receiveDAO;

@Controller
public class receiveServiceImpl implements receiveService {
	@Autowired
	private receiveDAO dao;
	
	public void setDao(receiveDAO dao) {
		this.dao = dao;
	}
	
	public ReceiveDataBean getReceive(int rm_id) {
		ReceiveDataBean list = null;
		try {
			list = dao.getReceive(rm_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public int insertreceive(ReceiveDataBean receive) {
		int check = 0;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int rm_id = receive.getRm_id();
		
		try{
			map.put("rm_title",receive.getRm_title());
			map.put("rm_content",receive.getRm_content());
			map.put("rm_date",receive.getRm_date());
			map.put("rm_sender",receive.getRm_sender());
			check = dao.insertreceive("receive.insertreceive", map);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return check;
		

	}
	public int deletereceive(int rm_id, int rm_check) {
		int list;
		
		String check = dao.deletecheck(rm_id);
		
		if(check.equals(check)){
		
		try {
			list = dao.deletereceive(rm_id);
		} catch (Exception e) {
		}
		return 1;
		}
		else{
			return 0;
		}
		
	}
	public List<Object> getReceives(int startRow,int endRow,String search,int searchn) {
		List<Object> list = null;
		
		if(search == null || search.equals(""))
			list = dao.getReceives(startRow, endRow);
		else
			list = dao.getReceives(startRow, endRow, searchn, search);
	

		return list;
	}
	


}
