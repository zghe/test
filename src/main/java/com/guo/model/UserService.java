package com.guo.model;

public class UserService {

	private BaseDao dao; 
	public void setDao(BaseDao dao) {
		this.dao = dao;
	}


	/**
	 * ����id��ѯ�û���Ϣ
	 * @author hzg
	 * @date 2012-9-12
	 * @return �û���Ϣ
	 */
	public UserBean getUserInfo(String id){
		return (UserBean) dao.queryById(id);
	}
}
