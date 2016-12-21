package receive.Service;

import java.util.List;

import org.springframework.stereotype.Controller;

import receive.DAO.ReceiveDataBean;

@Controller
public interface ReceiveService {
	public List<Object> getReceives(int startRow,int endRow,String search, int searchn);
	public ReceiveDataBean getReceive(int rm_id);
	public int getReceiveCount(String search, int searchn);
	public int insert(ReceiveDataBean receive);
	public int rdt(int rm_id, String rm_check);
	public int updateReceive(ReceiveDataBean receive,int rm_check);
	public void readcount(int rm_id);

}
