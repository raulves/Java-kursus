package ee.taltech.iti0202.testing;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class SentenceTest {

    @Test
    public void testAddPunctuation_EmptySentence_IsFalse() {
        Sentence sentence = new Sentence();

        boolean result = sentence.addPunctuation(".");

        assertFalse(result);
    }

    @Test
    public void testAddPunctuation_NotEmptySentence_IsTrue() {
        Sentence sentence = new Sentence("welcome to Estonia");

        boolean result = sentence.addPunctuation("!");

        assertTrue(result);
    }

    @Test
    public void testAddPunctuation_SentenceWithPunctuation_IsFalse() {
        Sentence sentence = new Sentence("welcome to Estonia!");

        boolean result = sentence.addPunctuation("?");

        assertFalse(result);
    }

    @Test
    public void testRemovePunctuation_PunctuationNotAdded_IsFalse() {
        Sentence sentence = new Sentence("welcome to Estonia");

        boolean result = sentence.removePunctuation();

        assertFalse(result);
    }

    @Test
    public void testRemovePunctuation_PunctuationAlreadyAdded_IsTrue() {
        Sentence sentence = new Sentence("welcome to Estonia!");

        boolean result = sentence.removePunctuation();

        assertTrue(result);
    }

    @Test
    public void testRemoveWord_RemovableWordNotInSentence_IsFalse() {
        Sentence sentence = new Sentence("welcome to Estonia");

        boolean result = sentence.removeWord("car");

        assertFalse(result);
    }

    @Test
    public void testRemoveWord_RemovableWordInSentenceHasAlreadyPunctuation_IsFalse() {
        Sentence sentence = new Sentence("welcome to Estonia.");

        boolean result = sentence.removeWord("welcome");

        assertFalse(result);
    }

    @Test
    public void testRemoveWord_RemovableWordInSentenceNoPunctuation_IsTrue() {
        Sentence sentence = new Sentence("welcome to Estonia");

        boolean result = sentence.removeWord("welcome");

        assertTrue(result);
    }

    @Test
    public void testAddWord_AddEmptyWord_IsFalse() {
        Sentence sentence = new Sentence("welcome to Estonia");

        boolean result = sentence.addWord("");

        assertFalse(result);
    }

    @Test
    public void testAddWord_AddWordHasPunctuation_IsFalse() {
        Sentence sentence = new Sentence("welcome to Estonia!");

        boolean result = sentence.addWord("home");

        assertFalse(result);
    }

    @Test
    public void testAddWord_AddWordNoPunctuation_IsTrue() {
        Sentence sentence = new Sentence("welcome to Estonia");

        boolean result = sentence.addWord("home");

        assertTrue(result);
    }

    @Test
    public void testAddWord_AddWord_EqualsTrue() {
        Sentence sentence = new Sentence("i like");

        sentence.addWord("honey");

        assertEquals(sentence.toString(), "I like honey...");
    }

    @Test
    public void testToString_EmptySentence_EmptyString() {
        Sentence sentence = new Sentence();

        assertEquals(sentence.toString(), "");
    }
}
