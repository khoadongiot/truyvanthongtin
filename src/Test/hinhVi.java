/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import edu.stanford.nlp.ling.WordTag;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import vn.hus.nlp.tagger.VietnameseMaxentTagger;

/**
 *
 * @author Dong Khoa
 */
public class hinhVi {
    public static List<String> TachDoanVan(String DoanVan) {
        List<String> DoanBaCau = new ArrayList();
        //Tách câu bằng BreakIterator
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        List<String> mang = new ArrayList();
        int slMang = 0;

        iterator.setText(DoanVan);
        int start = iterator.first();
        for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
            mang.add(DoanVan.substring(start, end));
            slMang++;

        }
        //Nếu văn bản có số lượng câu nhỏ hơn 3 thì thêm hết tất cả các câu đó .
        if (slMang < 3) {
            for (int j = 0; j < slMang; j++) {
                DoanBaCau.add(mang.get(j));
            }
        } else {
            int soluong3cau = slMang - 2;//Một văn bản chỉ xét tới câu thứ n - 2 . VD Văn bản có 5 câu thì xét tới câu thứ 3 . Khi đó ta sẽ có các đoạn là 123 , 234 , 345 . 
            for (int j = 0; j < soluong3cau; j++) {
                String temp = "";
                int tempJ = j;
                while (tempJ < j + 3) {
                    temp += mang.get(tempJ);
                    tempJ++;
                }
                DoanBaCau.add(temp);
            }
        }
        return DoanBaCau;
    }
    public static String LoaiBoStopWords(String CauTruyVan) {
        String query = CauTruyVan;
        VietnameseMaxentTagger tag = new VietnameseMaxentTagger();   
        List<WordTag> a = tag.tagText2(query );
        //Map<String, String> dict = new HashMap<>();
        String strTag = tag.tagText(query);
        System.out.println("Nhãn của các từ hiện tại : " + strTag);
        String query2 = "";
        String tempp = "";
        for (int t = 0; t < a.size(); t++) {
            String[] data = a.get(t).toString().split("/");

            if (data[1].equals("N") || data[1].equals("V") || data[1].equals("Np") || data[1].equals("Nc")
                    || data[1].equals("M") || data[1].equals("A") || data[1].equals("R") || data[1].equals("E") || data[1].equals("X")) {
                int tempDem = data[0].split(" ").length;
                if (tempDem >= 2) {
                    String str = data[0];
                    query2 += " " + "\"" + str + "\"" + " ";//Nếu là 1 từ lớn hơn 2 tiếng thì sẽ được đặt trong "" để có thể tìm chính xác hơn trong Lucene . VD : "hoa hậu" .
                } else {
                    query2 += " " + data[0];
                }
            }
            //Trong trường hợp không tồn tại nhãn nào thuộc N,V,Np,Nc,M,A,R,E,X  thì sẽ tìm kiếm bằng câu truy vấn ban đầu (nếu câu truy vấn có từ thì sẽ vẫn sẽ được tìm kiếm như cụm trong Lucene)
            int tempDem1 = data[0].split(" ").length;
            if (tempDem1 >= 2) {
                String str1 = data[0];
                tempp += " " + "\"" + str1 + "\"" + " ";
            } else {
                tempp += " " + data[0];
            }

        }
        query2 = query2.trim();
        query2 = query2.replaceAll("\\s+", " ");
        System.out.println("Từ để tìm kiếm : " + query2);

        tempp = tempp.trim();
        tempp = tempp.replaceAll("\\s+", " ");
        System.out.println("Từ để tìm kiếm dự phòng : " + tempp);

        if (query2.trim().isEmpty()) {
            query2 = tempp;
        }

        return query2;
    }
    public static void main(String[] agrs){
        String s = "Đại học và học sinh nhưng bởi vì";
        //System.out.println(TachDoanVan(s));
        System.out.println(LoaiBoStopWords(s));
    }
}
