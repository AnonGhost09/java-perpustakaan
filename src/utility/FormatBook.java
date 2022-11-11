package utility;

public abstract class FormatBook {
    public static String novelFormat(Integer size, Integer publication){
        return publication.toString() + "-A-" + size.toString();
    }
        public static String megazineFormat(Integer size, Integer publication){
            return publication.toString() + "-B-" + size.toString();
    }
}
