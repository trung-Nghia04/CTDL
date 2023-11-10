package task;
import java.io.FileNotFoundException;
public class TestReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		
	MyWordCountApp app = new MyWordCountApp();
	
	app.loadData();
	System.out.println("Số lượng tokens: "+app.countDistinct());
	System.out.println("Số lần tokens duy nhất xuất hiện: ");
	app.printWordCounts();
	System.out.println("Số lần tokens duy nhất xuất hiện theo thứ tự tăng dần: ");
	app.printWordCountsAlphabet();
	
	}
	
}
