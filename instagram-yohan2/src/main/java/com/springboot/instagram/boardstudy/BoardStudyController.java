package com.springboot.instagram.boardstudy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.instagram.boardstudy.db.BRepository;
import com.springboot.instagram.boardstudy.db.BoardStudy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  // @Autowired 대신 사용...
@Controller  // controller 안달면 IoC에 등록이 안되서 dispatcher가 밑의 mapping의 주소를 찾을 수 없다.
@RequestMapping("/study") // 밑의 /study를 빼도 된다.
public class BoardStudyController {
	
	private final BRepository bRepository;
	
	@Value("${test.filename}")  // 이 value 안의 값을 filename 안에 넣는다는 뜻
	private String filename;
	
	@Value("${file.path}")
	private String filePath;
	
	@GetMapping("/file")
	public String file() {
		
		File file = new File(filePath + filename);  // 파일경로, 파일명 이 들어가야한다.
//		if(!file.exists()) {  // 해당 객체가 생성되지 않았다면
//			file.mkdirs();    // make directory
//		}
		
		return null;
	}
	
//	@GetMapping("/study/board")  위에 @RequestMapping("/study") 했으니 밑에처럼 생략가능
	@GetMapping("/board")
	public String boardPage(Model model, @RequestParam int page) {   //model== jsp로 전달할 때에 사용. spring framework에 포함된... 이 메서드가 jsp로 전달될 때 사용되는 것. parameter로 int page를 받을 것이다
//		public String boardPage(Model model, @RequestParam int page, HttpServletRequest request) {   //model== jsp로 전달할 때에 사용. 이 메서드가 jsp로 전달될 때 사용되는 것. parameter로 int page를 받을 것이다
//		System.out.println(bRepository.getBoardList());
//		@RequestParam int page : page 변수명에 (주소창에서 확인가능) 숫자를 넣어준다. 
		
//		int page = request.getParameter("page"); // servlet, 이거랑 @RequestParam 과 기능이 같단다.
		
		List<BoardStudy> boardListAll = bRepository.getBoardList();
		
		if(page == 0) {
			model.addAttribute("b", boardListAll);
			
		}else {
			int boardListAllSize = boardListAll.size();
			int startIndex = (page -1 ) * 5;
			int endIndex = page * 5;
		
			List<BoardStudy> boardList = new ArrayList<BoardStudy>();
//		http://localhost:8002/study/board?page=0
		
			for(int i = startIndex ; i < endIndex && i < boardListAllSize ; i++) {
				boardList.add(boardListAll.get(i));
			}
			model.addAttribute("b", boardList);  
		} 
		return "study/board";  // jsp파일을 반환한다. board.jsp 파일
	}
}
