/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoidap;

import edu.stanford.nlp.ling.WordTag;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import vn.hus.nlp.tagger.VietnameseMaxentTagger;

/**
 *
 * @author VietDuc
 */
public class clsXuLy {

    public static double SoLuongCauHoi ;
    public static void HienThiLoaiCauHoi(int LoaiCauHoi){
         if (LoaiCauHoi == 1) {
            System.out.println("Loại câu hỏi về tên riêng người ");
        } else if (LoaiCauHoi == 2) {
            System.out.println("Loại câu hỏi về địa điểm ");
        } else if (LoaiCauHoi == 3) {
            System.out.println("Loại câu hỏi về thời điểm ");
        } else if (LoaiCauHoi == 4) {
            System.out.println("Loại câu hỏi về thời hạn ");
        } else if (LoaiCauHoi == 5) {
            System.out.println("Loại câu hỏi về chiều dài");
        } else if (LoaiCauHoi == 6) {
            System.out.println("Loại câu hỏi về khối lượng ");
        } else if (LoaiCauHoi == 7) {
            System.out.println("Loại câu hỏi về số lượng ");
        } else {
            System.out.println("Không phân loại được câu hỏi ");
        }
    }
        
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
    
    public static String LoaiBoTuHoi(String CauTruyVan) throws FileNotFoundException, UnsupportedEncodingException, IOException {       
        String query = CauTruyVan.trim();
        //Loại bỏ từ hỏi
        FileInputStream fis = new FileInputStream("tuhoi.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
        String tempStr = "";
        while ((tempStr = reader.readLine()) != null) {
            if (tempStr.equalsIgnoreCase("ai")) {
                if (query.startsWith(tempStr) || query.endsWith(tempStr)) {
                    query = query.replace(tempStr, " ");
                }
            } else {
                if (query.contains(tempStr)) {
                    query = query.replace(tempStr, " ");
                }
            }
        }
        fis.close();
        reader.close();
        query = query.trim();
        query = query.replaceAll("\\s", " ");
        return query;

    }
       
    public static List<String> XuLy(String CauHoi, int LoaiCauHoi, String PathDuLieu)  throws ParseException, IOException {
        List<String> KetQua = new ArrayList();
        List<String> NamKetQua = new ArrayList();
        CauHoi = CauHoi.replace("?", "");
        HienThiLoaiCauHoi(LoaiCauHoi);

        if (!CauHoi.trim().isEmpty()) {
            //Index dữ liệu với Lucene
            clsLucene.IndexLucene(PathDuLieu);
            
            String query = LoaiBoTuHoi(CauHoi);             
            System.out.println("Từ để tìm kiếm văn bản: " + query);
            
            //Search với Lucene         
            clsLucene.SearchLucene(query);
            
            //Phân tích văn bản thành từng đoạn văn chồng lấn nhau , mỗi đoạn văn có 3 câu . Sau đó đánh chỉ mục và tìm kiếm ra 5 đoạn văn có điểm số cao nhất
            List<String> DoanVan = new ArrayList();
            for (int i = 0; i < clsLucene.hits.length; ++i) {
                int docId = clsLucene.hits[i].doc;
                Document d = clsLucene.searcher.doc(docId);
                
                String source = d.get("content");
                List<String> DoanBaCau = new ArrayList();
                DoanBaCau = TachDoanVan(source);
                    
                //Index lại cho từng đoạn văn 
                StandardAnalyzer analyzer1 = new StandardAnalyzer();
                Directory index1 = new RAMDirectory();
                IndexWriterConfig config1 = new IndexWriterConfig(analyzer1);
                IndexWriter w1 = new IndexWriter(index1, config1);
                for (int j = 0; j < DoanBaCau.size(); ++j) {
                    Document doc = new Document();
                    doc.add(new TextField("content1", DoanBaCau.get(j), Field.Store.YES));
                    w1.addDocument(doc);
                }
                w1.close();

                String CauTruyVan = LoaiBoStopWords(query);//Loại bỏ stop words

                Query q2 = new QueryParser("content1", analyzer1).parse(CauTruyVan);

                //Tìm kiếm đoạn văn có điểm số cao nhất trong từng văn bản 
                int hitsPerPage2 = 1;
                IndexReader reader2 = DirectoryReader.open(index1);
                IndexSearcher searcher2 = new IndexSearcher(reader2);
                TopDocs docs2 = searcher2.search(q2, hitsPerPage2);
                ScoreDoc[] hits2 = docs2.scoreDocs;

                if (hits2.length > 0) {
                    int docId2 = hits2[0].doc;
                    Document d2 = searcher2.doc(docId2);
                    DoanVan.add(d2.get("content1"));
                }

            }

            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("\nCâu hỏi ban đầu : " + CauHoi);

            System.out.println("");
            System.out.println("\nTop 5 đoạn văn có thể chứa câu trả lời ");
            for (int i = 0; i < DoanVan.size(); ++i) {
                System.out.println("\n***********************************************************************************");
                System.out.println("Đoạn thứ  " + (i + 1) + "\n" + DoanVan.get(i));
                System.out.println("***********************************************************************************");
                System.out.println("");
            }

            //Rút trích kết quả           
            for (int i = 0; i < DoanVan.size(); i++) {
                String DuLieu = DoanVan.get(i);
                List<String> KetQuaTam = new ArrayList();
                KetQuaTam = clsRutTrichCauTraLoi.RutTrichKetQua(LoaiCauHoi, DuLieu);
                int Size = KetQuaTam.size();
                for (int j = 0; j < Size; j++) {
                    KetQua.add(KetQuaTam.get(j));
                    
                }
            }
        }
        //Nếu danh sách kết quả < 5 thì thêm "_" cho đến khi đủ
        if (KetQua.size() < 5) {
            for (int i = KetQua.size(); i < 5; i++) {
                KetQua.add("_");
            }
        }

        //Lấy 5 kết quả đầu tiên trong danh sách kết quả trả lời
        for (int t = 0; t < 5; t++) {
            if (KetQua.get(t).trim().isEmpty() || KetQua.get(t).equalsIgnoreCase(null)) {
                NamKetQua.add("_");
            } else {
                NamKetQua.add(KetQua.get(t));
            }
        }

        System.out.println("Câu hỏi ban đầu : " + CauHoi);
        System.out.println("Câu trả lời : ");
        for (int i = 0; i < NamKetQua.size(); i++) {
            System.out.println((i + 1) + ") " + NamKetQua.get(i));
        }
        return NamKetQua;
    }   
    
    public static List<String> XuLyFileCauHoi(String pathCauHoi ,String pathDuLieu )throws ParseException, IOException  {
        SoLuongCauHoi = 0;
        List<String> KetQua = new ArrayList();// Danh sách kết quả trả lời
        //Xét từng câu hỏi 
        FileInputStream input = new FileInputStream(pathCauHoi);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        String line = "";
        //Đọc từng câu hỏi
        while ((line = reader.readLine()) != null) {
            SoLuongCauHoi++;
            int LoaiCauHoi = clsPhanTichCauHoi.PhanLoaiCauHoi(line);
            List<String> KetQuaTam = clsXuLy.XuLy(line, LoaiCauHoi, pathDuLieu);
            for (int i = 0; i < KetQuaTam.size(); i++) {
                KetQua.add(KetQuaTam.get(i));//Thêm câu trả lời vào danh sách kết quả
            }
        }
        reader.close();

        return KetQua;
    }
}
