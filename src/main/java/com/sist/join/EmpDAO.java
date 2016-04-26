package com.sist.join;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpDAO {
	private static SqlSessionFactory sqlSessionFactory;
	static{
		try{
			Reader reader=Resources.getResourceAsReader("Config.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
			//SAX ÆÄ½ÌÇÔ.
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public static List<EmpVO> empdeptJoinAllData(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<EmpVO> list=sqlSession.selectList("empdeptJoinAllData");
		sqlSession.close();
		return list;
	}
	
	public static EmpVO empdeptJoinFindData(int empno){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		EmpVO list=sqlSession.selectOne("empdeptJoinFindData", empno);
		sqlSession.close();
		return list;
	}
}





























