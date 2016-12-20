package send.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import send.DAO.SendDataBean;
import send.DAO.sendDAO;

@Controller
public class sendServiceImpl implements sendService {
	@Autowired
	private sendDAO dao;
	
	public void setDao(sendDAO dao) {
		this.dao = dao;
	}
	public SendDataBean getSend(int sm_id) {
		SendDataBean list = null;
		try {
			list = dao.getSend(sm_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public int insertsend(SendDataBean send) {

	}
	public int deletesend(int sm_id, int sm_check) {
		int list;
		
		String check = dao.deletecheck(sm_id);
		
		if(check.equals(check)){
		
		try {
			list = dao.deletesend(sm_id);
		} catch (Exception e) {
		}
		return 1;
		}
		else{
			return 0;
		}
		
	}
	

}