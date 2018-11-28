package gacl.servlet.study;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ResponseDemo01")
public class ResponseDemo01 extends HttpServlet {

    private static final long serialVersionUID = 4312868947607181532L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        outputChineseByOutputStream(response);//浣跨敤OutputStream娴佽緭鍑轰腑鏂�
    }
    
    /**
     * 浣跨敤OutputStream娴佽緭鍑轰腑鏂�
     * @param request
     * @param response
     * @throws IOException 
     */
    public void outputChineseByOutputStream(HttpServletResponse response) throws IOException{
        /**浣跨敤OutputStream杈撳嚭涓枃娉ㄦ剰闂锛�
         * 鍦ㄦ湇鍔″櫒绔紝鏁版嵁鏄互鍝釜鐮佽〃杈撳嚭鐨勶紝閭ｄ箞灏辫鎺у埗瀹㈡埛绔祻瑙堝櫒浠ョ浉搴旂殑鐮佽〃鎵撳紑锛�
         * 姣斿锛歰utputStream.write("涓浗".getBytes("UTF-8"));//浣跨敤OutputStream娴佸悜瀹㈡埛绔祻瑙堝櫒杈撳嚭涓枃锛屼互UTF-8鐨勭紪鐮佽繘琛岃緭鍑�
         * 姝ゆ椂灏辫鎺у埗瀹㈡埛绔祻瑙堝櫒浠TF-8鐨勭紪鐮佹墦寮�锛屽惁鍒欐樉绀虹殑鏃跺�欏氨浼氬嚭鐜颁腑鏂囦贡鐮侊紝閭ｄ箞鍦ㄦ湇鍔″櫒绔浣曟帶鍒跺鎴风娴忚鍣ㄤ互浠TF-8鐨勭紪鐮佹樉绀烘暟鎹憿锛�
         * 鍙互閫氳繃璁剧疆鍝嶅簲澶存帶鍒舵祻瑙堝櫒鐨勮涓猴紝渚嬪锛�
         * response.setHeader("content-type", "text/html;charset=UTF-8");//閫氳繃璁剧疆鍝嶅簲澶存帶鍒舵祻瑙堝櫒浠TF-8鐨勭紪鐮佹樉绀烘暟鎹�
         */
      //  String data = "hello world";
     //   OutputStream outputStream = response.getOutputStream();//鑾峰彇OutputStream杈撳嚭娴�
        response.setHeader("content-type", "text/html;charset=UTF-8");//閫氳繃璁剧疆鍝嶅簲澶存帶鍒舵祻瑙堝櫒浠TF-8鐨勭紪鐮佹樉绀烘暟鎹紝濡傛灉涓嶅姞杩欏彞璇濓紝閭ｄ箞娴忚鍣ㄦ樉绀虹殑灏嗘槸涔辩爜
        /**
         * data.getBytes()鏄竴涓皢瀛楃杞崲鎴愬瓧鑺傛暟缁勭殑杩囩▼锛岃繖涓繃绋嬩腑涓�瀹氫細鍘绘煡鐮佽〃锛�
         * 濡傛灉鏄腑鏂囩殑鎿嶄綔绯荤粺鐜锛岄粯璁ゅ氨鏄煡鎵炬煡GB2312鐨勭爜琛紝
         * 灏嗗瓧绗﹁浆鎹㈡垚瀛楄妭鏁扮粍鐨勮繃绋嬪氨鏄皢涓枃瀛楃杞崲鎴怗B2312鐨勭爜琛ㄤ笂瀵瑰簲鐨勬暟瀛�
         * 姣斿锛� "涓�"鍦℅B2312鐨勭爜琛ㄤ笂瀵瑰簲鐨勬暟瀛楁槸98
         *         "鍥�"鍦℅B2312鐨勭爜琛ㄤ笂瀵瑰簲鐨勬暟瀛楁槸99
         */
        /**
         * getBytes()鏂规硶濡傛灉涓嶅甫鍙傛暟锛岄偅涔堝氨浼氭牴鎹搷浣滅郴缁熺殑璇█鐜鏉ラ�夋嫨杞崲鐮佽〃锛屽鏋滄槸涓枃鎿嶄綔绯荤粺锛岄偅涔堝氨浣跨敤GB2312鐨勭爜琛�
         */
      //  byte[] dataByteArr = data.getBytes("UTF-8");//灏嗗瓧绗﹁浆鎹㈡垚瀛楄妭鏁扮粍锛屾寚瀹氫互UTF-8缂栫爜杩涜杞崲
       // outputStream.write(dataByteArr);//浣跨敤OutputStream娴佸悜瀹㈡埛绔緭鍑哄瓧鑺傛暟缁�
        String data = "中国";
//通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setCharacterEncoding("UTF-8");
//设置将字符以"UTF-8"编码输出到客户端浏览器
        PrintWriter out = response.getWriter();//获取PrintWriter输出流
        out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
        out.write(data);//使用PrintWriter流向客户端输出字符

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}