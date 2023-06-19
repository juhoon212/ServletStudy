package dto;


/**
 * 이름      널?       유형             
------- -------- -------------- 	- 방명록 게시글 번호 : 시퀀스로 제공되는 자동 증가값
NUM     NOT NULL NUMBER         	- 방명록 게시글 작성자 : 사용자 입력값을 전달받아 저장
WRITER           VARCHAR2(50)   	- 방명록 게시글 제목 : 사용자 입력									
SUBJECT          VARCHAR2(200)      - 방명록 게시글 내용 : 사용자 입력
CONTENT          VARCHAR2(1000) 	- 게시글 작성날짜 : 시스템의 현재 날짜
REGDATE          DATE 
 * 
 *
 */
public class GuestDTO {
	
	private int num;
	private String writer;
	private String subject;
	private String content;
	private String regdate;
	
	public GuestDTO() {
		
	}
	
	
	public GuestDTO(int num, String writer, String subject, String content, String regdate) {
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
	
}
