import com.app.concordance.ConcordanceGenerator;
import com.app.concordance.FileReader;

public class AppRunner {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        String passage = fileReader.read();
        ConcordanceGenerator concordanceGenerator = new ConcordanceGenerator();
        concordanceGenerator.printConcordance(passage, concordanceGenerator);
    }


}
