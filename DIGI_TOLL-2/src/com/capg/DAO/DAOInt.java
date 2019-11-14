package com.capg.DAO;

import com.capg.dto.Pass_details;
import com.capg.dto.User_details;
import com.capg.dto.login_data;
import com.capg.dto.vehicle_details;
import com.capg.exceptions.DIGIExceptions;

public interface DAOInt {

	login_data verfyCredentials(String userid, String password) throws DIGIExceptions;

	String addUser(User_details user_bean) throws DIGIExceptions;

	vehicle_details GetvehicleDetails(String vehicleDetails) throws DIGIExceptions;

	String AddPassDetails(Pass_details pass_details) throws DIGIExceptions;

	Pass_details getPassDetails(String username) throws DIGIExceptions;

	String UpdatePassDetails(Pass_details pass_details) throws DIGIExceptions;

	String UpdateWalletDetails(int amount, String username, int wallet) throws DIGIExceptions;

}
