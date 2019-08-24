package com.bootdo.common.utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;

public class PoiWordToHtml {
	public static void main(String[] args) throws Throwable {
//		final String path = "E:\\";
//		final String file = "1.doc";
//		InputStream input = new FileInputStream(path + file);
//		HWPFDocument wordDocument = new HWPFDocument(input);
//		WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
//				DocumentBuilderFactory.newInstance().newDocumentBuilder()
//						.newDocument());
//		wordToHtmlConverter.setPicturesManager(new PicturesManager() {
//			public String savePicture(byte[] content, PictureType pictureType,
//					String suggestedName, float widthInches, float heightInches) {
//				return suggestedName;
//			}
//		});
//		wordToHtmlConverter.processDocument(wordDocument);
//		List pics = wordDocument.getPicturesTable().getAllPictures();
//		if (pics != null) {
//			for (int i = 0; i < pics.size(); i++) {
//				Picture pic = (Picture) pics.get(i);
//				try {
//					pic.writeImageContent(new FileOutputStream(path
//							+ pic.suggestFullFileName()));
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		Document htmlDocument = wordToHtmlConverter.getDocument();
//		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//		DOMSource domSource = new DOMSource(htmlDocument);
//		StreamResult streamResult = new StreamResult(outStream);
//		TransformerFactory tf = TransformerFactory.newInstance();
//		Transformer serializer = tf.newTransformer();
//		serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
//		serializer.setOutputProperty(OutputKeys.INDENT, "yes");
//		serializer.setOutputProperty(OutputKeys.METHOD, "html");
//		serializer.transform(domSource, streamResult);
//		outStream.close();
//		String content = new String(outStream.toByteArray());
//		FileUtils.writeStringToFile(new File(path, "人员选择系分.html"), content,
//				"utf-8");
		PoiWord03ToHtml("D:\\var\\uploaded_files\\ea20ab23-76e9-402d-bbc3-8adeec179029.doc");
//		PoiWord07ToHtml("E:\\2.docx");
//		PoiWord07ToHtml("E:\\3.docx");
	}
	
	/** 
	  * word07版本(.docx)转html 
	  * poi:word07在线预览 
	  * */  
	 public static void PoiWord07ToHtml (String filePath) throws IOException{
//		 System.out.println("filePathdocx"+""+filePath);
//		 String path = filePath.substring(0,filePath.lastIndexOf("\\")+1);
		 String path = filePath.substring(0,filePath.lastIndexOf("files")+6);
//		  System.out.println("路径"+path);
		 final String imagepath = path;
		 String fileName = filePath.substring(filePath.lastIndexOf("\\")+1,filePath.lastIndexOf("."));

	     String file2 = fileName+".html";
	     File f = new File(filePath);    
	      if (!f.exists()) {    
	            System.out.println("Sorry File does not Exists!");    
	        } else {    
	            if (f.getName().endsWith(".docx") || f.getName().endsWith(".DOCX")) {    
	                //读取文档内容    
	                InputStream in = new FileInputStream(f);    
	                XWPFDocument document = new XWPFDocument(in);
	                  
	                File imageFolderFile = new File(imagepath);    
	                //加载html页面时图片路径
	                XHTMLOptions options = XHTMLOptions.create().URIResolver( new BasicURIResolver("./"));
	                //图片保存文件夹路径
	                options.setExtractor(new FileImageExtractor(imageFolderFile));
	                OutputStream out = new FileOutputStream(new File(file2));
	                XHTMLConverter.getInstance().convert(document, out, options);
	                out.close();
	            } else {    
	                System.out.println("Enter only MS Office 2007+ files");    
	            }    
	        }
//	        return file2;
	 }  
	 
	 /** 
	  * word03版本(.doc)转html 
	  * poi:word03在线预览 
	  * */  
	 public static void PoiWord03ToHtml(String filePath) throws IOException, ParserConfigurationException, TransformerException{
//	    System.out.println("filePathdoc"+""+filePath);
//	    final String path = filePath.substring(0,filePath.lastIndexOf("/")+1);
		 String path = filePath.substring(0,filePath.lastIndexOf("files")+6);
//	    final String imagepath = path+"images\\"; 
	    final String imagepath = path; 
//	    System.out.println("filePath"+filePath);
	    String fileName = filePath.substring(filePath.lastIndexOf("/")+1,filePath.lastIndexOf("."));

         String file2 =fileName+".html";
         InputStream input = new FileInputStream(filePath);
	   HWPFDocument wordDocument = new HWPFDocument(input);
	   WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
	     DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
	   wordToHtmlConverter.setPicturesManager(new PicturesManager() {
	    public String savePicture(byte[] content, PictureType pictureType,
	      String suggestedName, float widthInches, float heightInches) {     //图片在html页面加载路径
	     return path+"images\\"+suggestedName;
	    }
	   });
	   wordToHtmlConverter.processDocument(wordDocument);
	   //获取文档中所有图片
	   List pics = wordDocument.getPicturesTable().getAllPictures();
	   if (pics != null) {
	    for (int i = 0; i < pics.size(); i++) {
	     Picture pic = (Picture) pics.get(i);
	     try {//图片保存在文件夹的路径
	      pic.writeImageContent(new FileOutputStream(imagepath
	        + pic.suggestFullFileName()));
	     } catch (FileNotFoundException e) {
	      e.printStackTrace();
	     }
	    }  
	   }  
	   //创建html页面并将文档中内容写入页面  
	   Document htmlDocument = wordToHtmlConverter.getDocument();  
	   ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
	   DOMSource domSource = new DOMSource(htmlDocument);  
	   StreamResult streamResult = new StreamResult(outStream);  
	   TransformerFactory tf = TransformerFactory.newInstance();  
	   Transformer serializer = tf.newTransformer();  
	   serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");  
	   serializer.setOutputProperty(OutputKeys.INDENT, "yes");  
	   serializer.setOutputProperty(OutputKeys.METHOD, "html");  
	   serializer.transform(domSource, streamResult);  
	   outStream.close();  
	   String content = new String(outStream.toString("UTF-8"));  
	   FileUtils.writeStringToFile(new File(path, fileName+".html"), content, "utf-8");
//	   return file2;
	 }  
}
