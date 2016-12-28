package send.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import send.dao.SendDAO;
import send.dao.SendDataBean;

@Controller
public class SendServiceImpl implements SendService {
	@Autowired
	private SendDAO senddao;

	public void setDao(SendDAO senddao) {
		this.senddao = senddao;
	}
	
	
	@Override
	public int insert(SendDataBean send) {
		System.out.println("insert »£√‚");
		int check = 0;
		
		check = senddao.insert("letter.insert", send);
			
		return check;

	}
	
	@Override
	public List<SendDataBean> getSends(int startRow,int endRow){
		List<SendDataBean> list = null;
		list = senddao.getSends(startRow, endRow);
		
		return list;
	}
	

}
