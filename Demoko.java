import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Demoko {
    public static void main(String[] args) {
        ArrayList<Language> languages = insertLang(new Language[] {
                new Filipino("Kumusta"),
                new Chinese("你好世界")
        });
        Translation translation = new Translation("HELLO", "Hello World", languages);

        languages = insertLang(new Language[] {
                new English("Bye Bye"),
                new Chinese("再见")
        });
        Translation translation2 = new Translation("BYE", "Good Bye", languages);
        printOriginalData(new Translation[] { translation, translation2 });
        printNewData(new Translation[] { translation, translation2 });

    }

    public static void printOriginalData(Translation[] translation) {
        List<String> li = getDisplays(translation);
        System.out.println("--- ORIGINAL DATA ---");
        System.out.printf("%-18s %-18s", "CODE", "TEXT");
        for (String s : li) {
            System.out.printf("%-18s", s);
        }
        System.out.println();

        for (Translation t : translation) {
            System.out.printf("%-18s %-18s", t.code, t.word);
            String[] arr = new String[li.size()];
            Arrays.fill(arr, "");

            for (Language l : t.languageList) {
                arr[li.indexOf(l.display)] = li.indexOf(l.display) == -1 ? "" : l.translation;
            }

            for (String s : arr) {
                System.out.printf("%-18s", s);
            }
            System.out.println();
        }

    }

    public static ArrayList<Language> insertLang(Language[] langs) {
        ArrayList<Language> langList = new ArrayList<>();
        for (Language lang : langs) {
            langList.add(lang);
        }
        return langList;
    }

    public static List<String> getDisplays(Translation[] translation) {
        List<String> li = new ArrayList<>();
        for (Translation t : translation) {
            for (Language l : t.languageList) {
                if (!li.contains(l.display)) {
                    li.add(l.display);
                }
            }
        }
        return li;
    }

    public static void printNewData(Translation[] translations) {
        System.out.println("\n--- NEW DATA ---");
        System.out.printf("%-18s %-18s %-18s", "CODE", "CULTURE", "VALUE");
        System.out.println();

        for (Translation t : translations) {
            for (Language l : t.languageList) {
                System.out.printf("%-18s %-18s %-18s", t.code, l.display, l.translation);
                System.out.println();
            }
        }
    }

}

// --------------------------------------
class Filipino extends Language {
    public Filipino(String translation) {
        this.lang = "Filipino";
        this.display = "fl-PH";
        this.translation = translation;
    }
}

class English extends Language {
    public English(String translation) {
        this.lang = "English";
        this.display = "en-US";
        this.translation = translation;
    }
}

class Chinese extends Language {
    public Chinese(String translation) {
        this.lang = "Chinese";
        this.display = "zh-CN";
        this.translation = translation;
    }
}