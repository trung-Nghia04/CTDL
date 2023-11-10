package task;

import java.io.IOException;

public class TextFileUtils {
	public static void main(String[] args) throws IOException {
		TextAnalyzer analyzer = new TextAnalyzer();
		analyzer.load("data/short.txt");
	    System.out.println("Danh sách ban đầu: \n"+ analyzer);
		
		analyzer.add("have", 8);
		System.out.println("Sau khi thêm value: have , key: 8: \n"+ analyzer);
		
		
		analyzer.add("You", -11);
		System.out.println("Sau khi thêm value: You , key: -11: \n"+ analyzer);
		
		System.out.println("Vị trí của mỗi từ, mỗi từ trên một dòng, theo thứ tự bảng chữ cái:");
		analyzer.displayWords();
		
		System.out.println("Hiển thị nội dung của tệp văn bản: ");
		analyzer.displayText();
		
		System.out.println("Trả về từ xuất hiện thường xuyên nhất: "+ analyzer.mostFrequentWord());
	}
}
