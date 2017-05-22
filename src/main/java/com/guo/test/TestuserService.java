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
 * �����û�service
 * easyMock-3.1.jar
 * @author hzg
 * @date 2012-9-11
 */
public class TestuserService {

	/**
	 * ���Ի�ȡ�û���Ϣ
	 * @author hzg
	 * @date 2012-9-11
	 */
	@Test
	public void testUser(){
		//����ʵ�����
		UserBean bean = new UserBean();
		//�趨ʵ�����ֵ��Ԥ��ֵ
		bean.setId("1001");
		bean.setUsername("hzg");
		bean.setPassword("123");
		//1������mock�����Խӿ���ʽ����
		BaseDao daoMock = EasyMock.createMock(BaseDao.class);
		//2���趨��Ԥ�ںͷ��أ���ѯԤ��ֵ�õ����趨��Ԥ�ڽ��
		EasyMock.expect(daoMock.queryById("1001")).andReturn(bean);
		//3������¼��
		EasyMock.replay(daoMock);
		
		//�Ƚ�service���õ�ֵ�Ƿ����趨��ֵ��ͬ
		UserService s = new UserService();
		s.setDao(daoMock);
		UserBean user = s.getUserInfo("1001");
		assertNotNull(user);
		assertEquals("1001",user.getId());
		assertEquals("hzg",user.getUsername());
		assertEquals("123",user.getPassword());
		//4���ط�¼��
		EasyMock.verify(daoMock);
		 
	}
	
	

	/**
	 * ���ϵķ�����ʵ�ʲ�����
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
	 *  ���ϵķ�����ʵ�ʲ�����
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
