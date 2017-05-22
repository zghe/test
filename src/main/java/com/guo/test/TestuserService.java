package com.guo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.servlet.http.HttpServletRequest;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;

import org.junit.Test;

import com.guo.model.BaseDao;
import com.guo.model.LoginServlet;
import com.guo.model.UserBean;
import com.guo.model.UserService;

/**
 * 测试用户service
 * easyMock-3.1.jar
 * @author hzg
 * @date 2012-9-11
 */
public class TestuserService {

	/**
	 * 测试获取用户信息
	 * @author hzg
	 * @date 2012-9-11
	 */
	@Test
	public void testUser(){
		//创建实体对象
		UserBean bean = new UserBean();
		//设定实体对象值，预期值
		bean.setId("1001");
		bean.setUsername("hzg");
		bean.setPassword("123");
		//1、创建mock对象，以接口形式创建
		BaseDao daoMock = EasyMock.createMock(BaseDao.class);
		//2、设定参预期和返回，查询预期值得到所设定的预期结果
		EasyMock.expect(daoMock.queryById("1001")).andReturn(bean);
		//3、结束录制
		EasyMock.replay(daoMock);
		
		//比较service调用的值是否与设定的值相同
		UserService s = new UserService();
		s.setDao(daoMock);
		UserBean user = s.getUserInfo("1001");
		assertNotNull(user);
		assertEquals("1001",user.getId());
		assertEquals("hzg",user.getUsername());
		assertEquals("123",user.getPassword());
		//4、回放录制
		EasyMock.verify(daoMock);
		 
	}
	
	

	/**
	 * 网上的方法，实际不能用
	 * @author hzg
	 * @date 2012-9-11
	 */
	@Test
	public void testMock() { 
		  HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		  request.getParameter("username");
		  request.setAttribute("username", "admin");
		  EasyMock.expect(request.getParameter("username")).andReturn("admin");
		  EasyMock.replay(request);
		  EasyMock.verify(request);
		 }
	
	/**
	 *  网上的方法，实际不能用
	 * @author hzg
	 * @date 2012-9-11
	 * @throws Exception
	 */
	@Test
	public void testLoginFailed() throws Exception {
		IMocksControl mc = EasyMock.createControl();
		HttpServletRequest request = mc.createMock(HttpServletRequest.class);
		// set Mock Object behavior.:
		request.getParameter("username");
		request.getParameter("password");
		request.setAttribute("username", "admin");
		request.setAttribute("password", "1234");
		//mc.setReturnValue("admin", 1);
		//mc.setReturnValue("1234", 1);
		EasyMock.expect(request.getParameter("username")).andReturn("admin").times(1);
		EasyMock.expect(request.getParameter("password")).andReturn("1234").times(1);
		// ok, all behaviors are set!
		mc.replay();
		// now starttest:
		LoginServlet servlet = new LoginServlet();
		try {
			servlet.doPost(request, null);
			fail("Not caught exception!");
		}
		catch(RuntimeException re) {
			assertEquals("Login failed.", re.getMessage());
		}
		// verify:
		mc.verify();
	}
	
}
