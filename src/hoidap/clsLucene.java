/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoidap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
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

/**
 *
 * @author VietDuc
 */
public class clsLucene {
    public static StandardAnalyzer analyzer;
    public static Directory index;
    public static IndexWriterConfig config;
    public static IndexWriter writer;
    public static IndexReader reader ;
    public static IndexSearcher searcher ;
    public static TopDocs docs ;
    public static ScoreDoc[] hits ;
    //Lucene Tutorial : http://www.lucenetutorial.com/lucene-in-5-minutes.html ; http://www.avajava.com/tutorials/lessons/how-do-i-use-an-index-in-memory.html
    public static String f = "";
    
    public static void IndexLucene(String PathDuLieu) throws IOException {
        analyzer = new StandardAnalyzer();
        index = new RAMDirectory();
        config = new IndexWriterConfig(analyzer);
        writer = new IndexWriter(index, config);

        //Lấy tất các các file trong folder
        File pathFolder = null;
        File[] paths;
        pathFolder = new File(PathDuLieu);
        paths = pathFolder.listFiles();

        //Load dữ liệu tất cả dữ liệu của thư mục folder vào
        for (File path : paths) {
            String temp = PathDuLieu + "//" + path.getName();
            Field filename = new StringField("filename", path.getName(), Field.Store.YES);

            FileInputStream input = new FileInputStream(temp);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));

            String noidung = "";
            String temp1 = "";
            while ((temp1 = reader.readLine()) != null) {
                noidung = noidung + temp1 + "\n";
            }
            input.close();
            reader.close();

            Document doc = new Document();
            doc.add(filename);
            Field addbody = new TextField("content", noidung, Field.Store.YES);
            doc.add(addbody);
            writer.addDocument(doc);

        }
        writer.close();
    }
    
    public static void SearchLucene(String query) throws ParseException, IOException{
            Query q = new QueryParser("content", analyzer).parse(query);
            //Tìm kiếm với Lucene
            int hitsPerPage = 5;
            reader = DirectoryReader.open(index);
            searcher = new IndexSearcher(reader);
            docs = searcher.search(q, hitsPerPage);
            hits = docs.scoreDocs;

            //Kết quả trả về 5 văn bản có điểm số cao nhất
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("Có  " + hits.length + " văn bản tìm được ");
            f="";
            for (int i = 0; i < hits.length; ++i) {
                int docId = hits[i].doc;
                Document d = searcher.doc(docId);
                System.out.println(d.get("filename"));
                f += d.get("filename")+ "\n";
            }   
    }    
}
