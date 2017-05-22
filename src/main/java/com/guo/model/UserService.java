package com.guo.model;

public class UserService {

	private BaseDao dao; 
	public void setDao(BaseDao dao) {
		this.dao = dao;
	}


	/**
	 * 根据id查询用户信息
	 * @author hzg
	 * @date 2012-9-12
	 * @return 用户信息
	 */
	public UserBean getUserInfo(String id){
		return (UserBean) dao.queryById(id);
	}
}
