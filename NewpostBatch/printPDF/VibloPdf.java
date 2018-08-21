package printPDF;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class VibloPdf {

	public static void main(String[] args) {
		String classpath = System.getProperty("java.class.classpath");
		System.out.println(classpath);
		// Tạo đối tượng tài liệu
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);

		try {

			// Tạo đối tượng PdfWriter
			PdfWriter.getInstance(document, new FileOutputStream("/home/mrson/viblo_asia.pdf"));

			// Mở file để thực hiện ghi
			document.open();

			// Thêm nội dung sử dụng add function
			document.add(new Paragraph("Viblo Asia"));

			Anchor anchorTarget = new Anchor("First page of the document.");
			anchorTarget.setName("BackToTop");
			document.add(anchorTarget);

			// Đóng File
			document.close();
			System.out.println("Write file succes!");
			createEx();
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public static void createEx() {
		try {
            String filename = "/home/mrson/NewExcelFile.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");  

            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("No.");
            rowhead.createCell(1).setCellValue("Name");
            rowhead.createCell(2).setCellValue("Address");
            rowhead.createCell(3).setCellValue("Email");

            HSSFRow row = sheet.createRow((short)1);
            row.createCell(0).setCellValue("1");
            row.createCell(1).setCellValue("Sankumarsingh");
            row.createCell(2).setCellValue("India");
            row.createCell(3).setCellValue("sankumarsingh@gmail.com");

            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            //workbook.;
            System.out.println("Your excel file has been generated!");

        } catch ( Exception ex ) {
            System.out.println(ex);
        }
	}
}

