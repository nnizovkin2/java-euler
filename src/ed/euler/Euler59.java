package ed.euler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Euler59 {
    public static void main(String[] args) {
        System.out.println("ab".chars().sum());
        System.out.println(new Euler59().decryptionCandidates().chars().sum());
    }

    String decryptionCandidates() {
        var keys = keys();
        var words = words();
        var text = text();

        var decryptedText = decrypt(text, keys);
        List<String> res = new ArrayList<>();

        for (String dt : decryptedText) {
            int threshold = 0;
            for (String word: words) {
                if(dt.contains(word)) {
                    threshold++;
                }
            }

            if(threshold > 150) {
                System.out.println(dt);
                return dt;
            }
        }
        return null;
    }

    List<String> words() {
        ArrayList<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("words.txt"))) {
            return stream.map(s->s.split(" ")[0]).filter(s->s.length()>2).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String text() {
        try {
            String res = Files.readString(Path.of("p059_cipher.txt"));
            StringBuilder sb = new StringBuilder();
            String[] bytes = res.split(",");
            for (String b: bytes) {
                sb.append((char)Integer.parseInt(b));
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ArrayList<String> decrypt(String text, ArrayList<String> keys) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> st = split(text, 3);
        for (String key: keys) {
            var ka = key.toCharArray();
            var decrypted = new StringBuilder();
            for (String tChunk : st) {
                char[] chunk = tChunk.toCharArray();
                for (int i = 0; i < chunk.length; i++) {
                    decrypted.append((char)(chunk[i] ^ ka[i]));
                }
            }
            res.add(decrypted.toString());
        }

        return res;
    }

    ArrayList<String> keys() {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            for (int j = 0; j < 26; j++) {
                StringBuilder s = new StringBuilder();
                s.append(ch);
                s.append((char)('a' + j));
                for (int k = 0; k < 26; k++) {
                    res.add(s + String.valueOf((char)('a' + k)));
                }
            }
        }

        return res;
    }

    private static ArrayList<String> split(String str, int size) {
        ArrayList<String> split = new ArrayList<>();
        for (int i = 0; i <= str.length() / size; i++) {
            split.add(str.substring(i * size, Math.min((i + 1) * size, str.length())));
        }
        return split;
    }
}
