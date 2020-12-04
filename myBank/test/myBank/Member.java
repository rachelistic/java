package myBank;

public class Member {

	String id;
	String pw;
	
	public Member() {} //인수가 없는 클래스 만들어놔야함
	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	} //투스트링이 없으니 myBank.Member@15db9742 이렇게 나옴
	
	@Override //제너레이트 투스트링
	public String toString() { //vo를 출력할 일이 있으면 투스트링을 만들어 놓는다.
		return "Member [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
}
