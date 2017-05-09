/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoidap;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author VietDuc
 */
public class clsMRR {

    public static double TinhMRR(List<String> KetQuaHeThong, String pathDapAn , double SoLuongCauHoi) throws IOException {
        double MRR = 0;

        FileInputStream input = new FileInputStream(pathDapAn);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        int Temp5 = 0;
        double TongDiem = 0;
        String Line = "";
        reader.read();
        System.out.println("----------------------Tính Điểm MRR----------------------");
        while ((Line = reader.readLine()) != null) {
            String[] mang = Line.split("[|]");
            int Temp = 0;
            while (true) {
                boolean Check = false; //Kiếm trả xem có câu trả lời trong 5 kết quả của hệ thống 
                for (int i = 0; i < mang.length; ++i) {
                    mang[i] = mang[i].trim();
                    if (KetQuaHeThong.get(Temp5 + Temp).toLowerCase().contains(mang[i].toLowerCase())) {
                        System.out.println("===>KetQua : " + KetQuaHeThong.get(Temp5 + Temp) + " có được ở kết quả thứ  : " + (Temp + 1));
                        Check = true;
                        break;
                    }
                }
                Temp++;
                if (Check) { //Nếu tồn tại đáp án trong kết quả của hệ thống 
                    double temp3 = Temp;
                    TongDiem = TongDiem + 1 / temp3;
                    System.out.println("Điểm : " + String.valueOf(1 / temp3));
                    break;
                }
                if (Temp == 5) {
                    break;//Nếu trong 5 đáp án không có câu trả lời thì xét câu hỏi tiếp theo
                }
            }
            Temp5 = Temp5 + 5 ;//Mỗi câu hỏi sẽ có 5 đáp án vậy nên sau mỗi lần xét đáp án của câu hỏi tiếp theo sẽ tăng 5 thứ tự . 
        }
        reader.close();
        MRR = (1/SoLuongCauHoi) * TongDiem ;
        return MRR;
    }

}
