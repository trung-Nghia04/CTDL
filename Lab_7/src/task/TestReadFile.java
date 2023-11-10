package task;

import java.io.FileNotFoundException;

public class TestReadFile {
	public static void main(String[] args) throws FileNotFoundException {
	   MyWordCount count = new MyWordCount();
	   System.out.println("In ra số lần mỗi token duy nhất xuất hiện: \n"+ count.getWordCounts());
	   System.out.println(" Trả về số xuất hiện 1 lần: \n" + count.getUniqueWords());
	   System.out.println("Các từ trùng lặp xuất hiện một lần trong kết quả: \n" + count.getDistinctWords() );
	   System.out.println("Các từ xuất hiện tăng dần theo số lần xuất hiện:  \n" +  count.printWordCounts());
	   System.out.println("Các từ xuất hiện giảm dần theo số lần xuất hiện:  \n" +  count.exportWordCountsByOccurence());
	   System.out.println("Xóa chữ N đầu dòng: \n" +count.filterWords("N") );
	   
	   
	}
}
