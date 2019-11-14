package com.capg.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.DAO.DAOInt;
import com.capg.dto.Pass_details;
import com.capg.dto.User_details;
import com.capg.dto.login_data;
import com.capg.dto.vehicle_details;
import com.capg.exceptions.DIGIExceptions;




@Service
public class ServiceImpl implements ServiceInt {

	@Autowired
	private DAOInt daoInt;

	public DAOInt getPerDAOInt() {
		return daoInt;
	}

	public void setPerDAOInt(DAOInt perDAOInt) {
		this.daoInt = perDAOInt;
	}

	@Override
	public login_data verfyCredentials(String userid, String password) throws DIGIExceptions {
		// TODO Auto-generated method stub
		return daoInt.verfyCredentials(userid, password);
	}

	@Override
	public String addUser(User_details user_bean) throws DIGIExceptions {
		// TODO Auto-generated method stub
		return daoInt.addUser(user_bean);
	}

	@Override
	public vehicle_details GetvehicleDetails(String vehicleDetails) throws DIGIExceptions {
		// TODO Auto-generated method stub
		return daoInt.GetvehicleDetails(vehicleDetails);
	}

	@Override
	public String AddPassDetails(Pass_details pass_details) throws DIGIExceptions {
		// TODO Auto-generated method stub
		return daoInt.AddPassDetails(pass_details);
	}

	@Override
	public Pass_details getPassDetails(String username) throws DIGIExceptions {
		// TODO Auto-generated method stub
		return daoInt.getPassDetails(username);
	}

	@Override
	public String UpdatePassDetails(Pass_details pass_details) throws DIGIExceptions {
		// TODO Auto-generated method stub
		return daoInt.UpdatePassDetails(pass_details);
	}

	@Override
	public String UpdateWalletDetails(int amount, String username, int wallet) throws DIGIExceptions {
		// TODO Auto-generated method stub
		return daoInt.UpdateWalletDetails(amount, username, amount);
	}
	
	
	

}
