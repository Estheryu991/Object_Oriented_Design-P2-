package src;


/**
 * Filters file names using command-line wildcards.
 * <p>
 * '*' matches any number of character.
 * '?' matches exactly one character.
 * <p>
 * Examples:
 * '*.md' matches all files with the markdown extension.
 * 'exercise_??.md' matches, for example, 'exercise_01.md'.
 *
 * @author You!
 */
public class FilePattern {
    private String p;

    /**
     * Creates a new instance of the FilePattern class that filters
     * file names based on the given pattern.
     *
     * @param pattern the pattern used to filter file names.
     * @see FilePattern
     */
    public FilePattern(String pattern) {
        this.p = pattern;

    }
i have passed the email and would love to ask if it is still available
            would you be able to have a call in the coming week? thanks!
    /**
     * Returns whether the given filename matches this pattern.
     *
     * @param f filename
     * @return true if filename matches the pattern
     */
    public boolean matches(String f) {
        int i = 0; //amount of interations is defined outside of the loop
        for (; i < p.length(); i++) {

            char c = p.charAt(i);
            switch (c) {
                case '?': continue;
                case '*': {
                    var newP = new FilePattern(p.substring(i+1));
                    for (int sub = i; sub <= f.length(); sub++) {
                        if (newP.matches(f.substring(sub))) return true;
                    }
                    return false;
                }
                default: {
                    if (f.length() <= i) return false; //out of bound exception handling
                    if (c != f.charAt(i)) return false;
                }
            }
        }
        return f.length() == i; //returns false when strings have different lengths
    }
}
