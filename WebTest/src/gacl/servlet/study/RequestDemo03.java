package gacl.servlet.study;

import java.io.IOException;
import java.text.MessageFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @author gacl
 * 鑾峰彇瀹㈡埛绔�氳繃Form琛ㄥ崟鎻愪氦涓婃潵鐨勫弬鏁�
 */
@WebServlet("/servlet/RequestDemo03")
public class RequestDemo03 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //瀹㈡埛绔槸浠TF-8缂栫爜鎻愪氦琛ㄥ崟鏁版嵁鐨勶紝鎵�浠ラ渶瑕佽缃湇鍔″櫒绔互UTF-8鐨勭紪鐮佽繘琛屾帴鏀讹紝鍚﹀垯瀵逛簬涓枃鏁版嵁灏变細浜х敓涔辩爜
        request.setCharacterEncoding("UTF-8");
        /**
         * 缂�&nbsp;&nbsp;鍙�(鏂囨湰妗�)锛�
           <input type="text" name="userid" value="NO." size="2" maxlength="2">
         */
        String userid = request.getParameter("userid");//鑾峰彇濉啓鐨勭紪鍙凤紝userid鏄枃鏈鐨勫悕瀛楋紝<input type="text" name="userid">
        /**
         * 鐢ㄦ埛鍚�(鏂囨湰妗�)锛�<input type="text" name="username" value="璇疯緭鍏ョ敤鎴峰悕">
         */
        String username = request.getParameter("username");//鑾峰彇濉啓鐨勭敤鎴峰悕
        /**
         * 瀵�&nbsp;&nbsp;鐮�(瀵嗙爜妗�)锛�<input type="password" name="userpass" value="璇疯緭鍏ュ瘑鐮�">
         */
        String userpass = request.getParameter("userpass");//鑾峰彇濉啓鐨勫瘑鐮�
        String sex = request.getParameter("sex");//鑾峰彇閫変腑鐨勬�у埆
        String dept = request.getParameter("dept");//鑾峰彇閫変腑鐨勯儴闂�
        //鑾峰彇閫変腑鐨勫叴瓒ｏ紝鍥犱负鍙互閫変腑澶氫釜鍊硷紝鎵�浠ヨ幏鍙栧埌鐨勫�兼槸涓�涓瓧绗︿覆鏁扮粍锛屽洜姝ら渶瑕佷娇鐢╣etParameterValues鏂规硶鏉ヨ幏鍙�
        String[] insts = request.getParameterValues("inst");
        String note = request.getParameter("note");//鑾峰彇濉啓鐨勮鏄庝俊鎭�
        String hiddenField = request.getParameter("hiddenField");//鑾峰彇闅愯棌鍩熺殑鍐呭
        String code = request.getParameter("inputCode");
        
        String instStr="";
        /**
         * 鑾峰彇鏁扮粍鏁版嵁鐨勬妧宸э紝鍙互閬垮厤insts鏁扮粍涓簄ull鏃跺紩鍙戠殑绌烘寚閽堝紓甯搁敊璇紒
         */
        for (int i = 0; insts!=null && i < insts.length; i++) {
            if (i == insts.length-1) {
                instStr+=insts[i];
            }else {
                instStr+=insts[i]+",";
            }
        }
        
        String htmlStr = "<table>" +
                            "<tr><td>濉啓鐨勭紪鍙凤細</td><td>{0}</td></tr>" +
                            "<tr><td>濉啓鐨勭敤鎴峰悕锛�</td><td>{1}</td></tr>" +
                            "<tr><td>濉啓鐨勫瘑鐮侊細</td><td>{2}</td></tr>" +
                            "<tr><td>閫変腑鐨勬�у埆锛�</td><td>{3}</td></tr>" +
                            "<tr><td>閫変腑鐨勯儴闂細</td><td>{4}</td></tr>" +
                            "<tr><td>閫変腑鐨勫叴瓒ｏ細</td><td>{5}</td></tr>" +
                            "<tr><td>濉啓鐨勮鏄庯細</td><td>{6}</td></tr>" +
                            "<tr><td>闅愯棌鍩熺殑鍐呭锛�</td><td>{7}</td></tr>" +
                        "</table>";
        htmlStr = MessageFormat.format(htmlStr, userid,username,userpass,sex,dept,instStr,note,hiddenField);

		HttpSession session = request.getSession();
        response.setCharacterEncoding("UTF-8");//璁剧疆鏈嶅姟鍣ㄧ浠TF-8缂栫爜杈撳嚭鏁版嵁鍒板鎴风
        response.setContentType("text/html;charset=UTF-8");//璁剧疆瀹㈡埛绔祻瑙堝櫒浠TF-8缂栫爜瑙ｆ瀽鏁版嵁
        Object code2 = session.getAttribute("authCode");
        if(code.equals(code2)) {
            response.getWriter().write(htmlStr);//显示结果表单
            return;
        }else {
        	response.getWriter().write("验证码错误");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}