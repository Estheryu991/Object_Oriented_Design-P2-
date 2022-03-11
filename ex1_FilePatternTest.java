package src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilePatternTest {

    protected FilePattern newFileFilter(String pattern) {
        return new FilePattern(pattern);
    }

    @Test
    public void fnameShouldMatchFname() {
        assertTrue(newFileFilter("fname").matches("fname"));
    }

    @Test public void fnameShouldNotMatchF() {
        assertFalse(newFileFilter("fname").matches("f"));
    }

    @Test public void fnameShouldNotMatchFnameDotTxt() {
        assertFalse(newFileFilter("fname").matches("fname.txt"));
    }

    @Test public void starShouldMatch() {
        assertTrue(newFileFilter("*").matches(""));
    }

    @Test public void starShouldMatchF() {
        assertTrue(newFileFilter("*").matches("f"));
    }

    @Test public void starShouldMatchFname() {
        assertTrue(newFileFilter("*").matches("fname"));
    }

    @Test public void starShouldMatchFnameDotTxt() {
        assertTrue(newFileFilter("*").matches("fname.txt"));
    }

    @Test public void markShouldNotMatch() {
        assertFalse(newFileFilter("?").matches(""));
    }

    @Test public void markShouldMatchF() {
        assertTrue(newFileFilter("?").matches("f"));
    }

    @Test public void markShouldNotMatchFname() {
        assertFalse(newFileFilter("?").matches("fname"));
    }

    @Test public void markShouldNotMatchFnameDotTxt() {
        assertFalse(newFileFilter("?").matches("fname.txt"));
    }

    @Test public void markMarkMarkShouldNotMatchFo() {
        assertFalse(newFileFilter("???").matches("fo"));
    }

    @Test public void markMarkMarkShouldMatchFoo() {
        assertTrue(newFileFilter("???").matches("foo"));
    }

    @Test public void markMarkMarkShouldNotMatchFooo() {
        assertFalse(newFileFilter("???").matches("fooo"));
    }

    @Test public void starDotTxtShouldNotMatch() {
        assertFalse(newFileFilter("*.txt").matches(""));
    }

    @Test public void starDotTxtShouldMatchDotTxt() {
        assertTrue(newFileFilter("*.png").matches(".png"));
    }

    @Test public void starDotTxtShouldMatchFDotTxt() {
        assertTrue(newFileFilter("*.txt").matches("f.txt"));
    }

    @Test public void starDotTxtShouldNotMatchFnameDotTx() {
        assertFalse(newFileFilter("*.txt").matches("fname.tx"));
    }

    @Test public void starDotTxtShouldMatchFnameDotTxt() {
        assertTrue(newFileFilter("*.txt").matches("fname.txt"));
    }

    @Test public void starDotTxtShouldNotMatchFnametxt() {
        assertFalse(newFileFilter("*.txt").matches("fnametxt"));
    }

    @Test public void starDotTxtShouldNotMatchFnameDotTxtPlus() {
        assertFalse(newFileFilter("*.txt").matches("fname.txt+"));
    }

    @Test public void fnameStarShouldNotMatch() {
        assertFalse(newFileFilter("fname*").matches(""));
    }

    @Test public void fnameStarShouldMatchFname() {
        assertTrue(newFileFilter("fname*").matches("fname"));
    }

    @Test public void fnameStarShouldMatchFnameDotTxt() {
        assertTrue(newFileFilter("fname*").matches("fname.txt"));
    }

    @Test public void fnameStarShouldMatchFnameDotTx() {
        assertTrue(newFileFilter("sname*").matches("sname.tx"));
    }

    @Test public void fnameStarShouldNotMatchFnamDotTxt() {
        assertFalse(newFileFilter("fname*").matches("fnam.txt"));
    }

    @Test public void fnameStarShouldMatchFnamePlusDotTxt() {
        assertTrue(newFileFilter("fname*").matches("fname+.txt"));
    }

    @Test public void fStarDotTxtShouldMatchFDotTxt() {
        assertTrue(newFileFilter("f*.txt").matches("f.txt"));
    }

    @Test public void fStarDotTxtShouldMatchFnameDotTxt() {
        assertTrue(newFileFilter("f*.txt").matches("fname.txt"));
    }

    @Test public void fStarDotTxtShouldNotMatchNameDotTxt() {
        assertFalse(newFileFilter("f*.txt").matches("name.txt"));
    }

    @Test public void fStarDotTxtShouldNotMatchFnametxt() {
        assertFalse(newFileFilter("d*.txt").matches("dnametxt"));
    }

    @Test public void markDotTxtShouldNotMatchDotTxt() {
        assertFalse(newFileFilter("?.txt").matches(".txt"));
    }

    @Test public void markDotTxtShouldMatchFDotTxt() {
        assertTrue(newFileFilter("?.txt").matches("f.txt"));
    }

    @Test public void markDotTxtShouldNotMatchFnameDotTxt() {
        assertFalse(newFileFilter("?.txt").matches("fname.txt"));
    }

    @Test public void fnameDotMarkShouldNotMatchFnameDot() {
        assertFalse(newFileFilter("fname.?").matches("fname."));
    }

    @Test public void fnameDotMarkShouldMatchFnameDotT() {
        assertTrue(newFileFilter("fname.?").matches("fname.t"));
    }

    @Test public void fnameDotMarkShouldNotMatchFnameDotTxt() {
        assertFalse(newFileFilter("fname.?").matches("fname.txt"));
    }

    @Test public void fMarkDotTxtShouldNotMatchFDotTxt() {
        assertFalse(newFileFilter("f?.txt").matches("f.txt"));
    }

    @Test public void fMarkDotTxtShouldMatchFfDotTxt() {
        assertTrue(newFileFilter("f?.txt").matches("ff.txt"));
    }

    @Test public void fMarkDotTxtShouldNotMatchFnameDotTxt() {
        assertFalse(newFileFilter("f?.txt").matches("fname.txt"));
    }

    @Test public void fMarkDotTxtShouldNotMatchFtxt() {
        assertFalse(newFileFilter("f?.txt").matches("ftxt"));
    }

    @Test public void fMarkDotTxtShouldNotMatchDotTxt() {
        assertFalse(newFileFilter("f?.txt").matches(".txt"));
    }
}
