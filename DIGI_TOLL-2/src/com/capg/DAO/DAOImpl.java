package com.capg.DAO;

import java.util.Calendar;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.dto.Pass_details;
import com.capg.dto.User_details;
import com.capg.dto.login_data;
import com.capg.dto.vehicle_details;
import com.capg.exceptions.DIGIExceptions;

@Repository

public class DAOImpl implements DAOInt {

	@Autowired
	public SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public login_data verfyCredentials(String userid, String password) throws DIGIExceptions {
		// TODO Auto-generated method stub
		login_data bean = null;
		try {
			Session session = sessionFactory.openSession();

			Query query = session.createQuery(" FROM login_data where loginid=:id and password=:pass");
			query.setParameter("id", userid);
			query.setParameter("pass", password);

			bean = (login_data) query.list().get(0);

		} catch (IndexOutOfBoundsException e) {
			return null;

		} catch (Exception e) {
			throw new DIGIExceptions("error in dao layer" + e);
		}

		System.out.println(bean);
		return bean;
	}

	@Override
	public String addUser(User_details user_bean) throws DIGIExceptions {
		// TODO Auto-generated method stub

		try {
			System.out.println(user_bean);
			Session session = sessionFactory.openSession();
			// System.out.println(session);
			session.beginTransaction();
			int x = (int) session.save(user_bean);

			session.getTransaction().commit();
			session.close();

			login_data bean = new login_data();
			bean.setLoginid(user_bean.getLoginid());
			bean.setPassword(user_bean.getPassword());
			bean.setRole(user_bean.getRole());
			Session session1 = sessionFactory.openSession();
			// System.out.println(session);
			session1.beginTransaction();
			int x1 = (int) session1.save(bean);

			session1.getTransaction().commit();
			session1.close();

		} catch (org.hibernate.exception.ConstraintViolationException e) {
			throw new DIGIExceptions("sql exception");
		} catch (Exception e) {
			System.out.println("error is " + e);
			return "EXCEPTION";
		}

		return "ADDED successfully";
	}

	@Override
	public vehicle_details GetvehicleDetails(String vehicleDetails) throws DIGIExceptions {
		// TODO Auto-generated method stub
		vehicle_details vehicle_bean = new vehicle_details();
		try {

			Session session = sessionFactory.openSession();

			Query query = session.createQuery(" FROM vehicle_details where vehicle_no=:Vehicle_no ");
			query.setParameter("Vehicle_no", vehicleDetails);

			vehicle_bean = (vehicle_details) query.list().get(0);

		} catch (IndexOutOfBoundsException e) {
			return null;

		} catch (Exception e) {
			throw new DIGIExceptions("error in dao layer" + e);
		}

		return vehicle_bean;
	}

	@Override
	public String AddPassDetails(Pass_details pass_details) throws DIGIExceptions {
		// TODO Auto-generated method stub
		System.out.println(pass_details);
		User_details user_details = new User_details();
		try {
			Session session = sessionFactory.openSession();

			Query query = session.createQuery(" FROM User_details where loginid=:loginid ");
			query.setParameter("loginid", pass_details.getVehicle_no());

			user_details = (User_details) query.list().get(0);

			java.sql.Date date1 = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			java.sql.Date end_date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			end_date.setDate(end_date.getDate()+15);
			pass_details.setVehicle_no(user_details.getVehicle_no());
			pass_details.setStart_date(date1);
			pass_details.setEnd_date(end_date);
			pass_details.setUsername(user_details.getLoginid());

			int fare = calculateFare(pass_details);
			pass_details.setRoutecost(fare);
			System.out.println(fare + "fare is this ");
			System.out.println(user_details.getWallet_amount() + "wallet is this ");
			if (fare > user_details.getWallet_amount()) {
				return "no funds";
			} else {
				pass_details.setWallet(user_details.getWallet_amount() - fare);

				Session session1 = sessionFactory.openSession();
				// System.out.println(session);

				session1.beginTransaction();
				int x1 = (int) session1.save(pass_details);

				session1.getTransaction().commit();
				session1.close();

				Query query1 = session
						.createQuery("update User_details set wallet_amount=:amount " + " where loginid = :username");
				query1.setParameter("username", pass_details.getUsername());
				query1.setParameter("amount", pass_details.getWallet());

				int result1 = query1.executeUpdate();
				if (result1 == 1) {
					return "sucess added";
				}

			}
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			throw new DIGIExceptions("sql exception");
		} catch (Exception e) {
			System.out.println("error is " + e);
			return "EXCEPTION";
		}

		return "ADDED successfully";

	}

	private int calculateFare(Pass_details pass_details) {
		// TODO Auto-generated method stub
		String type = pass_details.getPass_type();
		int ammount = pass_details.getWallet();
		String route = pass_details.getTollGateID();
		if (route.equals("TOLL 1")) {
			if (type.equals("monthly")) {
				ammount = 30 * 30;
			}
			if (type.equals("quaterly")) {
				ammount = 180 * 29;
			}
			if (type.equals("yearly")) {
				ammount = 365 * 29;
			}
		}
		if (route.equals("TOLL 2")) {
			if (type.equals("monthly")) {
				ammount = 30 * 25;
			}
			if (type.equals("quaterly")) {
				ammount = 180 * 23;
			}
			if (type.equals("yearly")) {
				ammount = 365 * 22;
			}
		}
		if (route.equals("TOLL 3")) {
			if (type.equals("monthly")) {
				ammount = 30 * 20;
			}
			if (type.equals("quaterly")) {
				ammount = 180 * 19;
			}
			if (type.equals("yearly")) {
				ammount = 365 * 18;
			}
		}
		return ammount;
	}

	@Override
	public Pass_details getPassDetails(String username) throws DIGIExceptions {
		// TODO Auto-generated method stub
		Pass_details Pass_bean = new Pass_details();
		try {
			Session session = sessionFactory.openSession();

			Query query = session.createQuery(" FROM Pass_details where username=:loginid ");
			query.setParameter("loginid", username);

			Pass_bean = (Pass_details) query.list().get(0);
			System.out.println("inside dao");
		} catch (IndexOutOfBoundsException e) {
			return null;

		} catch (Exception e) {
			throw new DIGIExceptions("error in dao layer" + e);
		}

		return Pass_bean;
	}

	@Override
	public String UpdatePassDetails(Pass_details pass_details) throws DIGIExceptions {

		try {
			System.out.println(pass_details);
			int fare = calculateFare(pass_details);
			pass_details.setRoutecost(fare);
			System.out.println(fare + "fare is this ");
			System.out.println(pass_details.getWallet() + "wallet is this ");
			if (fare > pass_details.getWallet()) {
				return "no funds";
			} else {
				pass_details.setWallet(pass_details.getWallet() - fare);
				Session session = sessionFactory.openSession();
				java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				Query query = session.createQuery(
						"update Pass_details set End_date=:End_date , wallet=:wallet " + " where username = :username");
				query.setParameter("username", pass_details.getUsername());
				query.setParameter("End_date", date);
				query.setParameter("wallet", pass_details.getWallet());

				int result = query.executeUpdate();

				Query query1 = session
						.createQuery("update User_details set wallet_amount=:amount " + " where loginid = :username");
				query1.setParameter("username", pass_details.getUsername());
				query1.setParameter("amount", pass_details.getWallet());

				int result1 = query1.executeUpdate();
				if (result1 == 1 && result == 1) {
					return "sucess added";
				}
			}
		} catch (Exception e) {

			System.out.println("DAO layer error" + e);
			throw new DIGIExceptions("error in dao layer" + e);
		}
		return "sucess";
	}

	@Override
	public String UpdateWalletDetails(int amount, String username, int wallet) throws DIGIExceptions {
		// TODO Auto-generated method stub
		try {
			
			Session session = sessionFactory.openSession();

			Query query = session.createQuery(" FROM User_details where loginid=:loginid ");
			query.setParameter("loginid", username);

			User_details user_details = (User_details) query.list().get(0);

			System.out.println("ammount" +amount+"wallet "+wallet);
			Session session1 = sessionFactory.openSession();
			Session session2 = sessionFactory.openSession();
			
			Query query1 = session1
					.createQuery("update Pass_details set  wallet=:wallet " + " where username = :username");
			query1.setParameter("username", username);

			query1.setParameter("wallet", amount+user_details.getWallet_amount());

			int result = query1.executeUpdate();

			Query query11 = session2
					.createQuery("update User_details set wallet_amount=:wallet " + " where loginid = :loginid");
			query11.setParameter("loginid", username);

			query11.setParameter("wallet", amount+user_details.getWallet_amount());
			int result1 = query11.executeUpdate();
			if (result1 == 1 && result == 1) {
				return "sucess added";
			}

		} catch (Exception e) {

			System.out.println("DAO layer error" + e);
			throw new DIGIExceptions("error in dao layer" + e);
		}
		return "sucess";
	}

}
