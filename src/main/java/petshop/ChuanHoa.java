package petshop;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class ChuanHoa {
    public static void main(String[] args) {
        String vietnameseString = "Chào bạn, tôi là Chatbot";
        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Translation translation = translate.translate(vietnameseString, Translate.TranslateOption.sourceLanguage("vi"), Translate.TranslateOption.targetLanguage("en"));
        String englishString = translation.getTranslatedText();
        System.out.println(englishString);
    }
}

