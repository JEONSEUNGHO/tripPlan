package receive.Service;

import java.util.List;

import org.springframework.stereotype.Controller;

import receive.DAO.ReceiveDataBean;

@Controller
public interface receiveService {
	public List<Object> getReceives(int startRow,int endRow,String search, int searchn);
	public ReceiveDataBean getReceive(int rm_id);
	public  int getReceiveCount(String search, int searchn);
	public int insertreceive(ReceiveDataBean receive);
	public int deletereceive(int rm_id);
	public int updatereceive(ReceiveDataBean receive);
	public void readcount(int rm_id);
	
	
	
}
