package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilePatternTestExtended {

	protected FilePattern newFileFilter(String string) {
		return new FilePattern(string);
	}
	
	/*
	 * New tests for the logic
     */

	@Test
	public void fMarkDotTxtShouldNotMatchDotTxt() {
		assertFalse(newFileFilter("f?.txt").matches(".txt"));
	}

	@Test
	public void fStarDotStarShouldMatchFnameDotTxt() {
		assertTrue(newFileFilter("*.*").matches("fname.txt"));
	}

	@Test
	public void fStarStarShouldMatchEmptyString() {
		assertTrue(newFileFilter("**").matches(""));
	}

	@Test
	public void fStarMarkShouldNotMatchEmptyString() {
		assertFalse(newFileFilter("*?").matches(""));
	}

	@Test
	public void fStarMarkStarShouldNotMatchEmptyString() {
		assertFalse(newFileFilter("*?*").matches(""));
	}

	@Test
	public void fStarMarkShouldMatchX() {
		assertTrue(newFileFilter("*?").matches("x"));
	}

	@Test
	public void fnameDotTextShouldNotMatch() {
		assertFalse(newFileFilter("fname.txt").matches("fnameAtxt"));
	}

	@Test
	public void fnameTTextShouldNotMatch() {
		assertFalse(newFileFilter("fnamettxt").matches("fname.txt"));
	}
    
    /*
     * Recursion test
     */

	@Test
	public void ananasDoesNotMatch() {
		assertFalse(newFileFilter("*ana").matches("ananas"));
	}

	@Test
	public void ananasMatch() {
		assertTrue(newFileFilter("*anas").matches("ananas"));
	}

	@Test
	public void doubelAnananas() {
		assertTrue(newFileFilter("*nas*anas").matches("ananasananas"));
	}

	@Test
	public void fMarkStarShouldMatchX() {
		assertTrue(newFileFilter("b*ac").matches("babac"));
	}
    
    
    /*
     * Additional tests to break regex
     * 
     */
	@Test
	public void fbracketDotTxtShouldMatch() {
		assertTrue(newFileFilter("f[.txt").matches("f[.txt"));
	}

	@Test
	public void fCircumflexDotTxtShouldMatch() {
		assertTrue(newFileFilter("f^.txt").matches("f^.txt"));
	}

	@Test
	public void fMarkDotTxtShouldMatch() {
		assertTrue(newFileFilter("f?.txt").matches("f?.txt"));
	}

	@Test
	public void fbrightracketDotTxtShouldMatch() {
		assertTrue(newFileFilter("f[.txt").matches("f[.txt"));
	}

	@Test
	public void fleftbracketDotTxtShouldMatch() {
		assertTrue(newFileFilter("f].txt").matches("f].txt"));
	}

	@Test
	public void frightbeautybracketDotTxtShouldMatch() {
		assertTrue(newFileFilter("f{.txt").matches("f{.txt"));
	}

	@Test
	public void fleftbeautybracketDotTxtShouldMatch() {
		assertTrue(newFileFilter("f}.txt").matches("f}.txt"));
	}

	@Test
	public void fMarkDotStarDotStarShouldMatch() {
		assertTrue(newFileFilter("f?.*.*").matches("f1.txt.bak"));
	}

	@Test
	public void dotsDoNotMatchEverything() {
		assertFalse(newFileFilter("...").matches("abc"));
	}

	@Test
	public void plusShouldMatchPlus() {
		assertTrue(newFileFilter("a+b.txt").matches("a+b.txt"));
	}

	@Test
	public void parenthesesShouldMatch() {
		assertTrue(newFileFilter("l(*)r.txt").matches("l(abc)r.txt"));
	}
}
