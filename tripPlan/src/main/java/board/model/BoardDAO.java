package board.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BoardDAO extends SqlSessionDaoSupport{

	/* 
	 * MainBoard method
	 * */
	//각 board별  MainBoard 조회
	public List<BoardDTO> mainBoardAll(int identified){
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
		boards = getSqlSession().selectList("board.mainBoardAll", identified);
		return boards;
	}
	//MainBoard 삽입
	public int insertMainBoard(BoardDTO board){
		System.out.println("insertMainBoard 접근");
		int check = getSqlSession().insert("board.insertMainBoard", board);
		System.out.println("insertMainBoard insert이후");
		return check;
	}
	//MainBoard 수정
	public int updateMainBoard(BoardDTO board){
		int check = getSqlSession().update("board.updateMainBoard", board);
		return check;
	}
	//MainBoard 삭제
	public int deleteMainBoard(int b_id){
		int check = getSqlSession().delete("board.deleteMainBoard", b_id);
		return check;
	}
	
	/* 
	 * SubBoard method
	 * */
	//MainBoard id를 가지고 있는 모든 SubBoardList 조회
	public List<SubBoardDTO> subBoardAll(int b_id){
		List<SubBoardDTO> subBoard = new ArrayList<>();
		subBoard = getSqlSession().selectList("board.subBoardAll", b_id);
		return subBoard;
	}
	//SubBoard 삽입
	public int insertSubBoard(SubBoardDTO subBoard){
		int check = getSqlSession().insert("board.insertSubBoard", subBoard);
		return check;
	}
	//SubBoard 수정
	public int updateSubBoard(SubBoardDTO subBoard){
		int check = getSqlSession().update("board.updateSubBoard", subBoard);
		return check;
	}
	//삭제는 mainBoard를 삭제하면 subBoard도 같이 삭제 되기 때문에 만들지 않음
}
