package anabolicandroids.chanobol.api.data;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.parceler.Parcel;

import java.lang.reflect.Type;

@Parcel
public class Thread extends Common {

    // Only used internally, no counterpart in 4Chan API
    public boolean dead;

    // Used internally to speed up rendering
    public String strippedSubject;
    public String excerpt;

    public Post toOpPost() {
        Gson gson = new Gson();
        Type type = new TypeToken<Post>() {}.getType();
        return gson.fromJson(gson.toJson(this), type);
    }

    // From Clover
    public static String generateTitle(Board board, Thread thread) {
        return generateTitle(board, thread, 100);
    }

    public static String generateTitle(Board board, Thread thread, int maxLength) {
        if (!TextUtils.isEmpty(thread.subject)) {
            return thread.subject;
        } else if (!TextUtils.isEmpty(thread.text)) {
            return "/" + board + "/ - " + thread.text.subSequence(0, Math.min(thread.text.length(), maxLength)).toString();
        } else {
            return "/" + board + "/" + thread.number;
        }
    }

    public static String generateTitle(String boardName, String threadNumber) {
            return "/" + boardName + "/" + threadNumber;
    }
}
