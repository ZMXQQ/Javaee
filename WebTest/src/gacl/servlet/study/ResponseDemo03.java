package gacl.servlet.study;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/ResponseDemo03")
public class ResponseDemo03 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setHeader("refresh", "5");//璁剧疆refresh鍝嶅簲澶存帶鍒舵祻瑙堝櫒姣忛殧5绉掗挓鍒锋柊涓�娆�
        //1.鍦ㄥ唴瀛樹腑鍒涘缓涓�寮犲浘鐗�
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //2.寰楀埌鍥剧墖
        //Graphics g = image.getGraphics();
        Graphics2D g = (Graphics2D)image.getGraphics();
        g.setColor(Color.WHITE);//璁剧疆鍥剧墖鐨勮儗鏅壊
        g.fillRect(0, 0, 80, 20);//濉厖鑳屾櫙鑹�
        //3.鍚戝浘鐗囦笂鍐欐暟鎹�
        g.setColor(Color.BLUE);//璁剧疆鍥剧墖涓婂瓧浣撶殑棰滆壊
        g.setFont(new Font(null, Font.BOLD, 20));
        g.drawString(makeNum(), 0, 20);
        //4.璁剧疆鍝嶅簲澶存帶鍒舵祻瑙堝櫒娴忚鍣ㄤ互鍥剧墖鐨勬柟寮忔墦寮�
        response.setContentType("image/jpeg");//绛夊悓浜巖esponse.setHeader("Content-Type", "image/jpeg");
        //5.璁剧疆鍝嶅簲澶存帶鍒舵祻瑙堝櫒涓嶇紦瀛樺浘鐗囨暟鎹�
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        //6.灏嗗浘鐗囧啓缁欐祻瑙堝櫒
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    /**
     * 鐢熸垚闅忔満鏁板瓧
     * @return
     */
    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(9999999)+"";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7-num.length(); i++) {
            sb.append("0");
        }
        num = sb.toString()+num;
        return num;
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}