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

/**
 *
 * @author VietDuc
 */
public class clsPhanTichCauHoi {
    public static boolean TimDangCauHoi(String path, String CauHoi) throws FileNotFoundException, IOException {
        FileInputStream input = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        reader.read();
        String TuDeHoi = "";
        while ((TuDeHoi = reader.readLine()) != null) {
            if (!TuDeHoi.trim().isEmpty()) {
                if (TuDeHoi.equalsIgnoreCase("ai")) {
                    if (CauHoi.startsWith(TuDeHoi) || CauHoi.endsWith(TuDeHoi)) {
                        return true;
                    }
                } else {
                    if (CauHoi.contains(TuDeHoi)) {
                        return true;
                    }
                }
            }
        }
        reader.close();
        return false;
    }

    public static int PhanLoaiCauHoi(String CauHoi) throws FileNotFoundException, IOException {

        int LoaiCauHoi = 0;
        if (TimDangCauHoi("nguoi.txt", CauHoi)) {
            LoaiCauHoi = 1;
        } else if (TimDangCauHoi("diadiem.txt", CauHoi)) {
            LoaiCauHoi = 2;
        } else if (TimDangCauHoi("thoidiem.txt", CauHoi)) {
            LoaiCauHoi = 3;
        } else if (TimDangCauHoi("thoihan.txt", CauHoi)) {
            LoaiCauHoi = 4;
        } else if (TimDangCauHoi("chieudai.txt", CauHoi)) {
            LoaiCauHoi = 5;
        } else if (TimDangCauHoi("khoiluong.txt", CauHoi)) {
            LoaiCauHoi = 6;
        } else if (TimDangCauHoi("soluong.txt", CauHoi)) {
            LoaiCauHoi = 7;
        }

        return LoaiCauHoi;
    }
    
}
