package gacl.servlet.study;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.code.util.AuthCode;

/**
 * Servlet implementation class getAuthCodeServlet
 */
@WebServlet("/getAuthCodeServlet")
public class getAuthCodeServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String authCode = AuthCode.getAuthCode();
		request.getSession().setAttribute("authCode", authCode);	//����֤�뱣�浽session�У������Ժ���֤
	    
		try {
			//����ͼƬ
			ImageIO.write(AuthCode.getAuthImg(authCode), "JPEG", response.getOutputStream());
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
