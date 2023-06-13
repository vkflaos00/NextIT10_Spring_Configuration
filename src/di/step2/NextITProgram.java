package di.step2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import di.step2.dao.DataBaseDriver;
import di.step2.dao.MysqlDriver;
import di.step2.dao.OracleDriver;
import di.step2.service.FreeBoardService;
import di.step2.service.MemberService;
import spring.Step2;

public class NextITProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//DataBaseDriver driver = new OracleDriver();
		//DataBaseDriver driver = new MysqlDriver();
		
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext();
		context.register(Step2.class);
		context.refresh();
		
		
		
		
		//글쓰기처리
		//FreeBoardService free = new FreeBoardService(driver);
		
		
		FreeBoardService free 
			= (FreeBoardService) context.getBean("free");
		free.insertBoard();
		
		MemberService member 
			= context.getBean(MemberService.class);
		member.inserMember();
		
	}

}
