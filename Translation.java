import java.util.ArrayList;

public class Translation {

    public ArrayList<Language> languageList;
    public String code;
    public String word;

    public Translation(String code, String word, ArrayList<Language> languageList) {
        this.code = code;
        this.word = word;
        this.languageList = languageList;
    }

}
