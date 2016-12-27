package board.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BoardDAO extends SqlSessionDaoSupport{

	/* 
	 * MainBoard method
	 * */
	//�� board��  MainBoard ��ȸ
	public List<BoardDTO> mainBoardAll(int identified){
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
		boards = getSqlSession().selectList("board.mainBoardAll", identified);
		return boards;
	}
	//MainBoard ����
	public int insertMainBoard(BoardDTO board){
		System.out.println("insertMainBoard ����");
		int check = getSqlSession().insert("board.insertMainBoard", board);
		System.out.println("insertMainBoard insert����");
		return check;
	}
	//MainBoard ����
	public int updateMainBoard(BoardDTO board){
		int check = getSqlSession().update("board.updateMainBoard", board);
		return check;
	}
	//MainBoard ����
	public int deleteMainBoard(int b_id){
		int check = getSqlSession().delete("board.deleteMainBoard", b_id);
		return check;
	}
	
	/* 
	 * SubBoard method
	 * */
	//MainBoard id�� ������ �ִ� ��� SubBoardList ��ȸ
	public List<SubBoardDTO> subBoardAll(int b_id){
		List<SubBoardDTO> subBoard = new ArrayList<>();
		subBoard = getSqlSession().selectList("board.subBoardAll", b_id);
		return subBoard;
	}
	//SubBoard ����
	public int insertSubBoard(SubBoardDTO subBoard){
		int check = getSqlSession().insert("board.insertSubBoard", subBoard);
		return check;
	}
	//SubBoard ����
	public int updateSubBoard(SubBoardDTO subBoard){
		int check = getSqlSession().update("board.updateSubBoard", subBoard);
		return check;
	}
	//������ mainBoard�� �����ϸ� subBoard�� ���� ���� �Ǳ� ������ ������ ����
}
