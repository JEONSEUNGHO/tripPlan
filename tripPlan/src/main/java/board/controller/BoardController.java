package board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

import board.model.BoardDAO;
import board.model.BoardDTO;
import board.model.FileDTO;
import board.model.ReplyDTO;
import board.model.SubBoardDTO;
import board.model.TotalBoardDTO;

@Controller
public class BoardController {
	
	@Autowired
	BoardDAO dao;
	private SimpleDateFormat formatter;
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	//��λ��� Ŭ�� �� ù ������
	@RequestMapping(value="/createBoard.do", method=RequestMethod.GET)
	public String createBoardForm(){
		return "createBoard";
	}
	
	//��� ���� Ŭ�� �� mainBoard �ۼ� �� ���� Ŭ�� ��
	@RequestMapping(value="/createBoard.do", method=RequestMethod.POST)
	public ModelAndView submitMainBoard(HttpServletRequest request, String b_title, String b_maincontents, MultipartHttpServletRequest b_mainphoto, String b_startdate, String b_enddate, String b_activity, String b_identified){			//jsp���� �� �޾ƿ;���
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("createSubBoard");
		//�̹��� ����
		List<MultipartFile> mf = b_mainphoto.getFiles("b_mainphoto");
		List<String> images = new ArrayList<>();
		images = fileUpload(mf);
		System.out.println("savePathController:::"+images.get(0));
		BoardDTO board = new BoardDTO(b_title, b_maincontents, images.get(0), currentTime(), b_startdate, b_enddate, Integer.parseInt(b_activity), Integer.parseInt(b_identified), (String)session.getAttribute("m_email"));
		System.out.println(board);
		session.setAttribute("board", board);
		//
		//mav.addObject("check", check);
		return mav;
	}
	
	
	//subBoard���� �Ϸ� ��ư Ŭ�� ��
	@RequestMapping(value="/createSubBoard.do", method=RequestMethod.POST)	//���� �ʿ�
	public ModelAndView submitSubBoard(HttpServletRequest request, String sb_destination[], String sb_subtitle[], String sb_subcontents[], String sb_tcharge[], String sb_fcharge[], String sb_rcharge[], String sb_tripdate[], MultipartHttpServletRequest sb_photo, String sb_lat[], String sb_lng[] ){
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("isCreateBoard");
		int check = 0;
		//���� üũ
		if(session.getAttribute("m_email")==null||session.getAttribute("m_email").equals("")){
			System.out.println("Session_m_email is null");
			check = 0;
			mav.addObject("check", check);
			return new ModelAndView("isSessionCheck");
		}
		BoardDTO board = (BoardDTO)session.getAttribute("board");
		dao.insertMainBoard(board);
		for(int i=0; i<sb_lat.length;i++){
			List<MultipartFile> mf = sb_photo.getFiles("sb_photo"+(i+1));
			List<String> images = new ArrayList<>();
			images = fileUpload(mf);
			System.out.println("size ::: "+images.size());
			//sb_destination[i]
			//sb_lat[i], sb_lng[i]
			SubBoardDTO subBoard = new SubBoardDTO("�Ⱦ�", sb_subtitle[i], sb_subcontents[i], Integer.parseInt(sb_tcharge[i]), Integer.parseInt(sb_fcharge[i]), Integer.parseInt(sb_rcharge[i]), sb_tripdate[i], "30.1111", "-6.1111", i+1, board.getB_id());
			for(int j=0;j<images.size();j++){
				if(j==0){
					subBoard.setSb_photo1(images.get(0));
				}else if(j==1){
					subBoard.setSb_photo2(images.get(1));
				}else if(j==2){
					subBoard.setSb_photo3(images.get(2));
				}else if(j==3){
					subBoard.setSb_photo4(images.get(3));
				}else if(j==4){
					subBoard.setSb_photo5(images.get(4));
				}
			}
			System.out.println(subBoard);
			check = dao.insertSubBoard(subBoard);
		}
		mav.addObject("board", board);
		mav.addObject("check", check);
		
		session.removeAttribute("board");;
		return mav;
	}
	//�� �Խ��� �� mainBoardList ��ȸ
	@RequestMapping(value="/reviewBoard.do", method=RequestMethod.GET)
	public ModelAndView selectAllMainBoard(int identified){
		ModelAndView mav = new ModelAndView("reviewBoard");
		List<BoardDTO> mainBoardList = new ArrayList<>();
		mainBoardList = dao.mainBoardAll(identified);
		mav.addObject("mainBoardList", mainBoardList);
		return mav;
	}
	// �Խ��� ���� ��ȸ
	@RequestMapping(value="/pathContents.do", method=RequestMethod.GET)
	public ModelAndView selectBoardContents(int b_id){
		ModelAndView mav = new ModelAndView("pathContents");
		List<TotalBoardDTO> boardContents = new ArrayList<>();
		List<ReplyDTO> replyList = new ArrayList<>();
		
		boardContents = dao.selectBoardContents(b_id);
		replyList = dao.selectReply(b_id);
		
		int totalCost = 0;
		//�Ѱ�� ���
		for(int i=0;i<boardContents.size();i++){
			totalCost += boardContents.get(i).getSb_tcharge();
			totalCost += boardContents.get(i).getSb_fcharge();
			totalCost += boardContents.get(i).getSb_rcharge();
		}
		System.out.println(boardContents.size());
		System.out.println("replyList.size() ::: "+replyList.size());
		mav.addObject("size", replyList.size());
		mav.addObject("replyList", replyList);
		mav.addObject("boardContents", boardContents);
		mav.addObject("totalCost",totalCost);
		return mav;
	}
	
	/*
	 * insert reply
	 */
	@RequestMapping(value="/insertReply.do", method=RequestMethod.POST)
	public ModelAndView insertReply(HttpServletRequest request, String b_id, String re_contents){
		ModelAndView mav = new ModelAndView("isreply");
		HttpSession session = request.getSession();
		int check = 0;
		//���� üũ
		if(session.getAttribute("m_email")==null||session.getAttribute("m_email").equals("")){
				System.out.println("Session_m_email is null");
				check = 0;
				mav.addObject("check", check);
				return new ModelAndView("isSessionCheck");
		}
		String m_email = (String)session.getAttribute("m_email");
		System.out.println("b_id"+b_id);
		ReplyDTO reply = new ReplyDTO(re_contents, currentTime(), Integer.parseInt(b_id), m_email);
		System.out.println(reply);
		check = dao.insertReply(reply);
		if(check == 0){
			check=0;
		}else{
			check=1;
		}
		mav.addObject("b_id", b_id);
		mav.addObject("check", check);
		return mav;
	}
	/*
	 * delete reply
	 */
	@RequestMapping(value="/deleteReply.do", method=RequestMethod.GET)
	public ModelAndView deleteReply(HttpServletRequest request, String re_id, String b_id){
		ModelAndView mav = new ModelAndView("isreply");
		HttpSession session = request.getSession();
		int check = 0;
		//���� üũ
		if(session.getAttribute("m_email")==null||session.getAttribute("m_email").equals("")){
				System.out.println("Session_m_email is null");
				check = 0;
				mav.addObject("check", check);
				return new ModelAndView("isSessionCheck");
		}
		check = dao.deleteReply(Integer.parseInt(re_id));
		if(check == 0){
			check=0;
		}else{
			check=2;
		}
		mav.addObject("b_id", Integer.parseInt(b_id));
		mav.addObject("check", check);
		return mav;
	}
	//���� �ð�
	public String currentTime(){
		formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return formatter.format(new Date());
	}
	public List<String> fileUpload(List<MultipartFile> mf){
		List<String> fileSavaPath = new ArrayList<>();
		String myFolder = "c:/images/";
		String realFolder = "http://s3.amazonaws.com/tripplan2017/pathImg/";
		File dir = new File(myFolder);
		int j=0;
		if(!dir.isDirectory()){
			dir.mkdirs();
		}
		 // �Ѿ�� ������ ����Ʈ�� ����
        if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {
             
        } else {
            for (int i = 0; i < mf.size(); i++) {
            	
                // ���� �ߺ��� ó��
                String genId = UUID.randomUUID().toString();
                // ���� ���ϸ�
                String originalfileName = mf.get(i).getOriginalFilename();
                 
                String saveFileName = genId + "." + originalfileName;
                // ����Ǵ� ���� �̸�
                String mySavePath = myFolder+saveFileName;
                String savePath = realFolder+ saveFileName; // ���� �� ���� ���
                
                long fileSize = mf.get(i).getSize(); // ���� ������
                if(!originalfileName.equals("")){
	                File uploadFile = new File(mySavePath);
	                try {
						mf.get(i).transferTo(uploadFile);
						uploadAWS(uploadFile);
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					} // ���� ����
	                FileDTO file = new FileDTO(originalfileName,saveFileName,savePath,fileSize);
	                	System.out.println("j ::"+j);
	                	fileSavaPath.add(j, savePath);
	                	j++;
	            }
            }
        }
        return fileSavaPath;
	}
	// AmazonWebServer�� �̹��� upload (��� Ŭ���������� �ø� �� �ְ� static���� ����)
	   public static void uploadAWS(File file) throws IOException {
	        String bucketName = "tripplan2017/pathImg";
	        // accessKey�� secretKey�� ���
	        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAISKDAQ7YRVLCDNAA", "wLNQEmjYXsshTWzn3fwmi5kLhUilNUSXolvvttET");
	           
	        // AWS��ü�� �����ϰ� config���� (key, regions)�� ���
	        AmazonS3 s3 = new AmazonS3Client(credentials).withRegion(Regions.US_EAST_1);
	        // ������ ��ü�� AWS�� ��� 
	        s3.putObject(new PutObjectRequest(bucketName, file.getName(), file));
	        System.out.println("AWS upload OK");
	   }
}
