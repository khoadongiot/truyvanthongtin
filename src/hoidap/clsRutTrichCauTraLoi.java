/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoidap;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author VietDuc
 */
public class clsRutTrichCauTraLoi {
    private static final String regexTenNguoi = "([Ôô]ng|[Bb]à|[Aa]nh|[Cc]hị|[Cc]hú|NSND|[Cc]ụ|[Tt]ác giả|TS.?|[Ll]uật sư|[Hh]ọa sĩ|[Vv]õ sư|[Đđ]ạo diễn|[Kk]ỷ lục gia|[Nn]ghệ nhân|[Gg]iáo sư|[Tt]iến sĩ|[Cc]on gái|[Cc]on trai|[Nn]hạc sĩ|[Cc]a sĩ|[Nn]hà nghiên cứu|[Nn]hà sưu tập|[Ll]àm bởi)\\s?(([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềếểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳýỵỷỹ]+\\s?){2,})";

    private static final String regexTenNguoi1 = "([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềếểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳýỵỷỹ]+\\s?){3,}";

    private static final String regexDiaDiem = "(([Ởở]|[Tt]hành phố|[Tt]ại|[Tt]ỉnh|[Hh]uyện|[Xx]ã|[Qq]uận|[Pp]hường|[Ấấ]p|[Đđ]ảo|[Bb]iển|[Cc]ầu|[Kk]hu vực|[Tt]hị xã|[Đđ]ô thị|[Mm]iền|[Vv]ùng|[Đđ]ịa điểm|[Cc]ông viên|[Đđ]ường|[V|v]ịnh|[Tt]òa nhà|[Nn]hà hàng|Q.|T[Pp]\\.?|P\\.)\\s?(((([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềếểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳýỵỷỹ]*\\s?–?\\s?)+){1,}|[0-9]+[/-][0-9]|[0-9]+),?\\s?))+";

    private static final String regexThoiDiem = "([Nn]gày\\s?[0-9]+\\s?[Tt]háng\\s?[0-9]+\\s[Nn]ăm\\s[0-9]{4})|((0?[1-9]|[12][0-9]|3[01])[./-](0?[1-9]|1[012])[-/.]((19|20)\\d\\d)\\s?[–]?\\s?)+|(([Nn]ăm|[Nn]gày|[Tt]háng|[Ss]áng|[Cc]hiều|[Tt]ối|Noel|[Ll]ễ phục sinh)\\s?(([0-9]+([./-][0-9]+)+)|((0?[1-9]|[12][0-9]|3[01])[./-](0?[1-9]|1[012])[-/.]((19|20)\\d\\d))|((0?[1-9]|[12][0-9]|3[01])[./-](0?[1-9]|1[012]))|((19|20)\\d\\d))|((0?[1-9]|[12][0-9]|3[01])[./-](0?[1-9]|1[012])[./-]((19|20)\\d\\d))|([0-9]+\\s-\\s[0-9]+\\/[0-9]+)|([Tt]uổi\\s([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềếểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳýỵỷỹ]+\\s?)+)|(\\([0-9]{4,}\\)))";

    private static final String regexThoiHan = "(([0-9]+([./-][0-9]+)+)|([0-9]+))\\s?(ngày|tháng|năm|giờ|phút|giây|s)";

    private static final String regexChieuDai = "([0-9]+\\s?[x-]\\s?[0-9]\\s?(Km2|m2|mm2|km|mét|m|cm|mm|thước|ha|hải lý))|([0-9]+\\s?(Km2|m2|mm2|km|mét|m|cm|mm|thước|ha|hải lý)(\\s?x\\s?)?)+|(([0-9]+[,.m]?)+\\s?(Km2|m2|mm2|km|mét|m|cm|mm|thước|ha|hải lý)[0-9]*)";

    private static final String regexKhoiLuong = "(([0-9]+[,.-][0-9]+)|([0-9]+))\\s?(Kilogram|gram|Kg|kg|tấn|tạ|yến|kí|g|lít)";

    private static final String regexSoLuong = "(([0-9]+([./-][0-9]+)+)|([0-9]+))\\s?(người|nghệ nhân|bông hoa|mẫu|loại|chiếc|cánh|nhà thiết kế|buổi|tập|sản phẩm|bánh|huấn luyện viên|rồng|lá|bạn|thành viên|cặp đôi|tên lửa|đầu bếp|cây|tấm)";
          
    public static void GhiKetQuaRaFile(List<String> KetQua, String pathDapAnHeThong) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        //Ghi kết quả ra file đáp án của hệ thống
        FileOutputStream output = new FileOutputStream(pathDapAnHeThong);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, "UTF-8"));
        System.out.println();
        System.out.println("Số lượng đáp án : " + KetQua.size());
        for (int i = 0; i < KetQua.size(); i++) {
            System.out.println(KetQua.get(i));
            if (i == KetQua.size() - 1) {
                writer.write(KetQua.get(i));
                //writer.newLine();
            } else {
                writer.write(KetQua.get(i));
                writer.newLine();
            }
        }
        writer.close();
    }
    
    public static List<String> RutTrichKetQua(int LoaiCauHoi, String DoanVan) {
        String strDoanVan = DoanVan;
        strDoanVan = strDoanVan.replaceAll("\n", ";");//Thay ký tự xuống dòng để có thể dùng biểu thức chính quy chính xác hơn
        List<String> KetQua = new ArrayList();
        //Rút trích kết quả           

        //Loại câu hỏi là tên riêng người
        if (LoaiCauHoi == 1) {
            String strTam = "";
            Pattern pattern = Pattern.compile(regexTenNguoi);
            Matcher matcher = pattern.matcher(strDoanVan);
            while (matcher.find()) {
                String Temp = matcher.group(2).trim();
                strTam += Temp + "|";

            }
            //Nếu không có kết quả thì sử dụng regex tên người khác
            if (strTam.isEmpty()) {
                String str1Tam = "";
                Pattern pattern1 = Pattern.compile(regexTenNguoi1);
                Matcher matcher1 = pattern1.matcher(strDoanVan);
                while (matcher1.find()) {
                    String Temp1 = matcher1.group().trim();
                    str1Tam += Temp1 + "|";
                }
                strTam = str1Tam.trim();
            }

            //Loại bỏ kết quả trùng
            String[] ArrTemp = strTam.split("[|]");
            System.out.println("Số lượng : " + ArrTemp.length);
            String strTam1 = "";
            for (int j = 0; j < ArrTemp.length; j++) {
                boolean bool = true;
                for (int k = j + 1; k < ArrTemp.length; k++) {
                    if (ArrTemp[j].equalsIgnoreCase(ArrTemp[k])) {
                        bool = false;
                    }
                }
                if (bool == true) {
                    strTam1 = ArrTemp[j].trim();
                    if (!strTam1.isEmpty()) {
                        KetQua.add(strTam1);//Thêm câu trả lời vào danh sách kết quả trả lời
                    }
                }
            }
            if (strTam1.isEmpty()) {
                strTam1 = "_";
                KetQua.add(strTam1);//Nếu không có câu trả lời thì thêm "_"
            }
            //Loại câu hỏi về địa điểm
        } else if (LoaiCauHoi == 2) {
            String strTam = "";
            Pattern pattern = Pattern.compile(regexDiaDiem);
            Matcher matcher = pattern.matcher(strDoanVan);
            while (matcher.find()) {
                String Temp = matcher.group().trim();
                if (!Temp.equalsIgnoreCase(strTam)) {
                    strTam += Temp + "|";
                }
            }
            //Loại bỏ kết quả trùng
            String[] ArrTemp = strTam.split("[|]");
            String StrTam1 = "";
            for (int j = 0; j < ArrTemp.length; j++) {
                boolean bool = true;
                for (int k = j + 1; k < ArrTemp.length; k++) {
                    if (ArrTemp[j].equalsIgnoreCase(ArrTemp[k])) {
                        bool = false;
                    }
                }
                if (bool == true) {
                    StrTam1 = ArrTemp[j].trim();
                    if (!StrTam1.isEmpty()) {
                        KetQua.add(StrTam1);//Thêm câu trả lời vào danh sách kết quả trả lời
                    }
                }

            }
            if (StrTam1.trim().isEmpty()) {
                StrTam1 = "_";
                KetQua.add(StrTam1);//Nếu không có câu trả lời thì thêm "_"
            }
            //Loại câu hỏi về thời điểm
        } else if (LoaiCauHoi == 3) {
            String strTam = "";
            Pattern pattern = Pattern.compile(regexThoiDiem);
            Matcher matcher = pattern.matcher(strDoanVan);
            while (matcher.find()) {
                String Temp = matcher.group().trim();
                if (!Temp.equalsIgnoreCase(strTam)) {
                    strTam += Temp + "|";
                }
            }
            //Loại bỏ kết quả trùng
            String[] ArrTemp = strTam.split("[|]");
            String StrTam1 = "";
            for (int j = 0; j < ArrTemp.length; j++) {
                boolean bool = true;
                for (int k = j + 1; k < ArrTemp.length; k++) {
                    if (ArrTemp[j].equalsIgnoreCase(ArrTemp[k])) {
                        bool = false;
                    }
                }
                if (bool == true) {
                    StrTam1 = ArrTemp[j].trim();
                    if (!StrTam1.isEmpty()) {
                        KetQua.add(StrTam1);//Thêm câu trả lời vào danh sách kết quả trả lời
                    }
                }

            }
            if (StrTam1.trim().isEmpty()) {
                StrTam1 = "_";
                KetQua.add(StrTam1);//Nếu không có câu trả lời thì thêm "_"
            }
            //Loại câu hỏi về thời hạn                       
        } else if (LoaiCauHoi == 4) {
            String strTam = "";
            Pattern pattern = Pattern.compile(regexThoiHan);
            Matcher matcher = pattern.matcher(strDoanVan);
            while (matcher.find()) {
                String Temp = matcher.group().trim();
                if (!Temp.equalsIgnoreCase(strTam)) {
                    strTam += Temp + "|";
                }
            }
            //Loại bỏ kết quả trùng
            String[] ArrTemp = strTam.split("[|]");
            String StrTam1 = "";
            for (int j = 0; j < ArrTemp.length; j++) {
                boolean bool = true;
                for (int k = j + 1; k < ArrTemp.length; k++) {
                    if (ArrTemp[j].equalsIgnoreCase(ArrTemp[k])) {
                        bool = false;
                    }
                }
                if (bool == true) {
                    StrTam1 = ArrTemp[j].trim();
                    if (!StrTam1.isEmpty()) {
                        KetQua.add(StrTam1);//Thêm câu trả lời vào danh sách kết quả trả lời
                    }
                }

            }
            if (StrTam1.trim().isEmpty()) {
                StrTam1 = "_";
                KetQua.add(StrTam1);//Nếu không có câu trả lời thì thêm "_"
            }
            //Loại câu hỏi về chiều dài
        } else if (LoaiCauHoi == 5) {
            String strTam = "";
            Pattern pattern = Pattern.compile(regexChieuDai);
            Matcher matcher = pattern.matcher(strDoanVan);
            while (matcher.find()) {
                String Temp = matcher.group().trim();
                if (!Temp.equalsIgnoreCase(strTam)) {
                    strTam += Temp + "|";
                }
            }
            //Loại bỏ kết quả trùng
            String[] ArrTemp = strTam.split("[|]");
            String StrTam1 = "";
            for (int j = 0; j < ArrTemp.length; j++) {
                boolean bool = true;
                for (int k = j + 1; k < ArrTemp.length; k++) {
                    if (ArrTemp[j].equalsIgnoreCase(ArrTemp[k])) {
                        bool = false;
                    }
                }
                if (bool == true) {
                    StrTam1 = ArrTemp[j].trim();
                    if (!StrTam1.isEmpty()) {
                        KetQua.add(StrTam1);//Thêm câu trả lời vào danh sách kết quả trả lời
                    }
                }

            }
            if (StrTam1.trim().isEmpty()) {
                StrTam1 = "_";
                KetQua.add(StrTam1);//Nếu không có câu trả lời thì thêm "_"
            }
            //Loại câu hỏi về khối lượng
        } else if (LoaiCauHoi == 6) {
            String strTam = "";
            Pattern pattern = Pattern.compile(regexKhoiLuong);
            Matcher matcher = pattern.matcher(strDoanVan);
            while (matcher.find()) {
                String Temp = matcher.group().trim();
                if (!Temp.equalsIgnoreCase(strTam)) {
                    strTam += Temp + "|";
                }
            }
            //Loại bỏ kết quả trùng
            String[] ArrTemp = strTam.split("[|]");
            String StrTam1 = "";
            for (int j = 0; j < ArrTemp.length; j++) {
                boolean bool = true;
                for (int k = j + 1; k < ArrTemp.length; k++) {
                    if (ArrTemp[j].equalsIgnoreCase(ArrTemp[k])) {
                        bool = false;
                    }
                }
                if (bool == true) {
                    StrTam1 = ArrTemp[j].trim();
                    if (!StrTam1.isEmpty()) {
                        KetQua.add(StrTam1);//Thêm câu trả lời vào danh sách kết quả trả lời
                    }
                }

            }
            if (StrTam1.trim().isEmpty()) {
                StrTam1 = "_";
                KetQua.add(StrTam1);//Nếu không có câu trả lời thì thêm "_"
            }
            //Loại câu hỏi về số lượng
        } else if (LoaiCauHoi == 7) {
            String strTam = "";
            Pattern pattern = Pattern.compile(regexSoLuong);
            Matcher matcher = pattern.matcher(strDoanVan);
            while (matcher.find()) {
                String Temp = matcher.group().trim();
                if (!Temp.equalsIgnoreCase(strTam)) {
                    strTam += Temp + "|";
                }
            }
            //Loại bỏ kết quả trùng
            String[] ArrTemp = strTam.split("[|]");
            String StrTam1 = "";
            for (int j = 0; j < ArrTemp.length; j++) {
                boolean bool = true;
                for (int k = j + 1; k < ArrTemp.length; k++) {
                    if (ArrTemp[j].equalsIgnoreCase(ArrTemp[k])) {
                        bool = false;
                    }
                }
                if (bool == true) {
                    StrTam1 = ArrTemp[j].trim();
                    if (!StrTam1.isEmpty()) {
                        KetQua.add(StrTam1);//Thêm câu trả lời vào danh sách kết quả trả lời
                    }
                }

            }
            if (StrTam1.trim().isEmpty()) {
                StrTam1 = "_";
                KetQua.add(StrTam1);//Nếu không có câu trả lời thì thêm "_"
            }
            //Nếu không tìm được dạng câu hỏi thì sẽ so khớp lần lượt với 7 loại biểu thức chính quy để lấy kết quả
        } else {
            //Dùng biểu thức chính quy tên riêng người
            String strTam = "";
            Pattern pattern = Pattern.compile(regexTenNguoi);
            Matcher matcher = pattern.matcher(strDoanVan);
            while (matcher.find()) {
                String Temp = matcher.group(2).trim();
                System.out.println(Temp);
                strTam += Temp + "|";

            }
            //Nếu không có kết quả thì sử dụng biểu thức chính quy tên riêng người khác
            if (strTam.isEmpty()) {
                String str1Tam = "";
                Pattern pattern1 = Pattern.compile(regexTenNguoi1);
                Matcher matcher1 = pattern1.matcher(strDoanVan);
                while (matcher1.find()) {
                    String Temp1 = matcher1.group().trim();
                    System.out.println(Temp1);
                    str1Tam += Temp1 + "|";
                }
                strTam = str1Tam.trim();
            }

            //Dùng biểu thức chính quy địa điểm
            Pattern pattern2 = Pattern.compile(regexDiaDiem);
            Matcher matcher2 = pattern2.matcher(strDoanVan);
            while (matcher2.find()) {
                String Temp = matcher2.group().trim();
                strTam += Temp + "|";
            }
            //Dùng biểu thức chính quy thời điểm
            Pattern pattern3 = Pattern.compile(regexThoiDiem);
            Matcher matcher3 = pattern3.matcher(strDoanVan);
            while (matcher3.find()) {
                String Temp = matcher3.group().trim();
                strTam += Temp + "|";

            }
            //Dùng biểu thức chính quy thời hạn
            Pattern pattern4 = Pattern.compile(regexThoiHan);
            Matcher matcher4 = pattern4.matcher(strDoanVan);
            while (matcher4.find()) {
                String Temp = matcher4.group().trim();
                strTam += Temp + "|";

            }
            //Dùng biểu thức chính quy thời hạn
            Pattern pattern5 = Pattern.compile(regexChieuDai);
            Matcher matcher5 = pattern5.matcher(strDoanVan);
            while (matcher5.find()) {
                String Temp = matcher5.group().trim();
                strTam += Temp + "|";

            }
            //Dùng biểu thức chính quy chiều dài
            Pattern pattern6 = Pattern.compile(regexChieuDai);
            Matcher matcher6 = pattern6.matcher(strDoanVan);
            while (matcher6.find()) {
                String Temp = matcher6.group().trim();
                strTam += Temp + "|";

            }
            //Dùng biểu thức chính quy số lượng
            Pattern pattern7 = Pattern.compile(regexSoLuong);
            Matcher matcher7 = pattern7.matcher(strDoanVan);
            while (matcher7.find()) {
                String Temp = matcher7.group().trim();
                strTam += Temp + "|";

            }

            //Loại bỏ kết quả trùng
            String[] ArrTemp = strTam.split("[|]");
            System.out.println("Số lượng : " + ArrTemp.length);
            String strTam1 = "";
            for (int j = 0; j < ArrTemp.length; j++) {
                boolean bool = true;
                for (int k = j + 1; k < ArrTemp.length; k++) {
                    if (ArrTemp[j].equalsIgnoreCase(ArrTemp[k])) {
                        bool = false;
                    }
                }
                if (bool == true) {
                    strTam1 = ArrTemp[j].trim();
                    if (!strTam1.isEmpty()) {
                        KetQua.add(strTam1);//Thêm câu trả lời vào danh sách kết quả trả lời
                    }
                }
            }
        }

        return KetQua;
    }
         
}
