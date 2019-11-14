package com.capg.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.capg.dto.Pass_details;
import com.capg.dto.User_details;
import com.capg.dto.login_data;
import com.capg.dto.vehicle_details;
import com.capg.exceptions.DIGIExceptions;
import com.capg.service.ServiceInt;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
@Controller
@Scope("session")
@MultipartConfig(maxFileSize = 16177215)
public class DIGIController {
	String username = "";
	String toll="";
	int wallet=0;
	Pass_details Pass_bean=null;
	private static final String QR_CODE_IMAGE_PATH = "N:/java/workspace/MyQRCode.png";
	@Autowired
	private ServiceInt serviceInt;

	public ServiceInt getPerService() {
		return serviceInt;
	}

	public void setPerService(ServiceInt ServiceInt) {
		this.serviceInt = ServiceInt;
	}

	@RequestMapping(value = "/Login.html")
	public ModelAndView loginsho() {
		return new ModelAndView("LOGIN");
	}

	@RequestMapping(value = "/loginrequest.html")
	public ModelAndView verify(@RequestParam("feild1") String userid, @RequestParam("feild2") String password)
			throws DIGIExceptions {
		try {

			login_data bean = serviceInt.verfyCredentials(userid, password);
			username = bean.getLoginid();
			System.out.println(bean.getRole());
			if (bean.getRole().equals("admin")) {
				return new ModelAndView("successAdminLogin");
			}
			if (bean.getRole().equals("user")) {
				return new ModelAndView("successUserLogin", "message", "SUCCESFULLY LOGGED AS USER");
			}
		} catch (Exception e) {

			return new ModelAndView("LOGIN", "message", "Invalid credentilas ");
		}
		return new ModelAndView("errorpage");

	}

	@RequestMapping(value = "/register.html")
	public ModelAndView register() {
		return new ModelAndView("registerUser");
	}

	@RequestMapping(value = "/registerRequest.html")
	public ModelAndView registerRequest(@RequestParam("email") String mailid, @RequestParam("username") String username,
			@RequestParam("mobile") String mobile, @RequestParam("password") String password,
			@RequestParam("Rpassword") String Rpassword, @RequestParam("vehicle") String vehicle_no)
			throws DIGIExceptions {
		User_details user_bean = new User_details();
		ModelAndView mv = new ModelAndView();
		String result = "";
		try {
			System.out.println(password + "hai this is this" + Rpassword);
			System.out.println(!Rpassword.equals(password));
			if (!Rpassword.equals(password)) {
				mv.setViewName("registerUser");
				mv.addObject("message", "PLEASE ENTER SAME  value for PASSWORD and RE-ENtER PASSWORD ");
				return mv;
			}
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			user_bean.setDate_of_register(date);
			user_bean.setLoginid(username);
			user_bean.setMailId(mailid);
			user_bean.setMobile(mobile);
			user_bean.setRole("user");
			user_bean.setWallet_amount(0);
			user_bean.setVehicle_no(vehicle_no);
			user_bean.setPassword(Rpassword);
			System.out.println("before adding to add user" + user_bean);
			result = serviceInt.addUser(user_bean);

		} catch (Exception e) {

			if (e.toString().equals("com.capg.exceptions.DIGIExceptions: sql exception")) {

				return new ModelAndView("registerUser", "message", "use unique usernames");
			} else {
				return new ModelAndView("errorpage");
			}

		}

		return new ModelAndView("successRegistered", "message", "SUCCESSFULLY added ");
	}

	@RequestMapping(value = "/vehicle_details.html")
	public ModelAndView vehicleDetails() {
		return new ModelAndView("vehicleDetails");
	}

	@RequestMapping(value = "/GetvehicleDetails.html")
	public ModelAndView GetvehicleDetails(@RequestParam("vehicleDetails") String vehicleDetails) throws DIGIExceptions {
		vehicle_details vehicle_details = new vehicle_details();
		ModelAndView mv = new ModelAndView();
		try {

			vehicle_details = serviceInt.GetvehicleDetails(vehicleDetails);
			mv.addObject("bean", vehicle_details);
			mv.setViewName("registerUser");
			System.out.println(vehicleDetails);
			if (vehicle_details.getVehicle_no() != null)
				return mv;

		} catch (Exception e) {
			System.out.println(e);
			if (e.toString().equals("java.lang.NullPointerException"))
				return new ModelAndView("errorpage", "message", "vehicle details not found");

		}
		return new ModelAndView("successRegistered");
	}

	@RequestMapping(value = "/applypass.html")
	public ModelAndView NEWPass() {
		return new ModelAndView("ApplyPass");
	}

	@RequestMapping(value = "/SavePass.html")
	public ModelAndView NEWPASSregistering(@RequestParam("type") String type, @RequestParam("toll") String toll)
			throws DIGIExceptions {
		Pass_details pass_details = new Pass_details();
		ModelAndView mv = new ModelAndView();
		try {

			pass_details.setPass_type(type);
			pass_details.setTollGateID(toll);
			pass_details.setVehicle_no(username);

			String Fundstatus = serviceInt.AddPassDetails(pass_details);
			if (Fundstatus.equals("no funds")) {
				return new ModelAndView("ApplyPass", "message", "PLease add money in wallet");
			}
			Pass_bean=serviceInt.getPassDetails(username);
		} catch (Exception e) {

			if (e.toString().equals("com.capg.exceptions.DIGIExceptions: sql exception")) {

				return new ModelAndView("ApplyPass", "message", "PLease use renewal pass Option");
			} else {
				return new ModelAndView("errorpage");
			}

		}
		String qrcode="HI "+username+" ur details are \nPass id:"+Pass_bean.getId()+"\n Pass END date"+Pass_bean.getEnd_date()+"\n vehicle no :"+Pass_bean.getVehicle_no();
		
		try {
            generateQRCodeImage(qrcode, 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
    
			
		return new ModelAndView("successRegistered", "message", "SUCCESSFULLY added please check the path  for the qr code image "+QR_CODE_IMAGE_PATH);
	}

	@RequestMapping(value = "/Renewalpass.html")
	public ModelAndView RenewalPass() {
		ModelAndView mv = new ModelAndView();
		try {
			Pass_details Pass_bean = serviceInt.getPassDetails(username);
			mv.addObject("message",
					"YOUR last date is " + Pass_bean.getEnd_date() + "     your wallet has RS." + Pass_bean.getWallet());
			mv.setViewName("RenewPass");
			toll=Pass_bean.getTollGateID();
			wallet=Pass_bean.getWallet();
		} catch (DIGIExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping(value = "/SaveRENEWPass.html")
	public ModelAndView RENEWPASS(@RequestParam("type") String type) throws DIGIExceptions {
		Pass_details pass_details = new Pass_details();
		ModelAndView mv = new ModelAndView();
		try {
			System.out.println(username+"username is ");
			pass_details.setPass_type(type);
			pass_details.setTollGateID(toll);
			pass_details.setUsername(username);
			pass_details.setWallet(wallet);
			String status = serviceInt.UpdatePassDetails(pass_details);
			 Pass_bean = serviceInt.getPassDetails(username);
			if (status.equals("no funds")) {
				return new ModelAndView("ApplyPass", "message", "PLease add money in wallet");
			}
		} catch (Exception e) {

			if (e.toString().equals("com.capg.exceptions.DIGIExceptions: sql exception")) {

				return new ModelAndView("ApplyPass", "message", "PLease use renewal pass Option");
			} else {
				return new ModelAndView("errorpage");
			}

		}
		String qrcode="HI "+username+" ur details are \nPass id:"+Pass_bean.getId()+"\n Pass END date"+Pass_bean.getEnd_date()+"\n vehicle no :"+Pass_bean.getVehicle_no();
		try {
            generateQRCodeImage(qrcode, 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
    
		System.out.println(qrcode);
		return new ModelAndView("successRegistered", "message", "SUCCESSFULLY added please check the path  for the qr code image "+QR_CODE_IMAGE_PATH);
	}

	@RequestMapping(value = "/TOPUP.html")
	public ModelAndView TOPUP() {
		return new ModelAndView("TOPUP");
	}

	@RequestMapping(value = "/AddWallet.html")
	public ModelAndView ADDWallet(@RequestParam("amount") int amount)
			throws DIGIExceptions {
		try {
			
			String status = serviceInt.UpdateWalletDetails(amount,username,wallet);
		} catch (Exception e) {

			return new ModelAndView("error");
		}
		return new ModelAndView("successRegistered", "message", "SUCCESSFULLY added ");

	}

    private static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        	System.out.println(filePath);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
    @SuppressWarnings("unused")
	private static String decodeQRCode(File qrCodeimage) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            System.out.println("There is no QR code in the image");
            return null;
        }
    }

    @RequestMapping(value = "/ReadQRcode.html")
	public ModelAndView readQRcode() {
    	String decodedText=null;
    	try {
            File file1 = new File("N:/java/workspace/MyQRCode.png");
             decodedText= decodeQRCode(file1);
            if(decodedText == null) {
                System.out.println("No QR Code found in the image");
            } else {
                System.out.println("Decoded text = " + decodedText);
            }
        } catch (IOException e) {
            System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
        }
    	
		return new ModelAndView("successRegistered","QRmessage",decodedText);
	}
    
    
}
