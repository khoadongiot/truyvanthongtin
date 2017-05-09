/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoidap;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 *
 * @author VietDuc
 */
public class clsCWS {

    public static double TinhCWS(List<String> KetQuaHeThong, String pathDapAn, double SoLuongCauHoi) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        double CWS = 0;
        FileInputStream input = new FileInputStream(pathDapAn);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        int temp5 = 0;
        double temp1 = 0;//Số lượng câu hỏi hiện tại
        double SoCauDung = 0;
        double TongDiem = 0;
        
        String Line = "";
        reader.read();
        System.out.println("----------------------Tính Điểm CWS----------------------");
        while ((Line = reader.readLine()) != null) {
            String[] mang = Line.split("[|]");
            for (int i = 0; i < mang.length; i++) {
                mang[i] = mang[i].trim();
                //Kiểm tra xem kết quả đầu tiên trong 5 kết quả có phải là đáp án không .
                if (KetQuaHeThong.get(temp5).toLowerCase().contains(mang[i].toLowerCase())) {
                    SoCauDung++;
                    break;
                }
            }
            temp1++;
            double temp2 = temp1;
            TongDiem = TongDiem + SoCauDung / temp2;
            System.out.println("Điểm : " + String.valueOf(SoCauDung / temp2));

            temp5 = temp5 + 5;//Mỗi câu hỏi sẽ có 5 đáp án vậy nên sau mỗi lần xét đáp án của câu hỏi tiếp theo sẽ tăng 5 thứ tự . 
        }
        reader.close();
        CWS = (1 / SoLuongCauHoi) * TongDiem;
        return CWS;
    }
}
