package ee.taltech.iti0202.testing;

import junit.framework.TestCase;
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
        Sentence sentence = new Sentence("welcome welcome to Estonia");

        boolean result = sentence.removeWord("welcome");

        assertTrue(result);
    }

    @Test
    public void testRemoveWord_RemoveWordEmptySentence_IsFalse() {
        Sentence sentence = new Sentence();

        boolean result = sentence.removeWord("car");

        assertFalse(result);
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

    @Test
    public void testToString_SentenceManyPunctuations_LeavesOnePunctuation() {
        Sentence sentence = new Sentence("i like. honey and! money.");

        assertEquals(sentence.toString(), "I like.");
    }

    @Test
    public void testToString_SentenceHasMultipleWhitespaces_RemovesExcessWhitespaces() {
        Sentence sentence = new Sentence("i   like       honey");

        assertEquals(sentence.toString(), "I like honey...");
    }


    @Test
    public void testToString_SentenceWithPunctuationRemovePunctuationAddWordAddPunctuation() {
        Sentence sentence = new Sentence("i like honey.");

        sentence.removePunctuation();
        sentence.addWord("and");
        sentence.addWord("money");
        sentence.addPunctuation("!");

        assertEquals(sentence.toString(), "I like honey and money!");
    }


    @Test
    public void testAddWord_AddWordWithWhitespace_IsFalse() {
        Sentence sentence = new Sentence("i like honey");

        boolean result = sentence.addWord("and money");

        assertFalse(result);
    }


    @Test
    public void testPunctuationPartOfWord_PunctuationsStays() {
        Sentence sentence = new Sentence("so.me po.in.ts he,re but only end counts. yes.");

        assertEquals(sentence.toString(), "So.me po.in.ts he,re but only end counts.");
    }

    @Test
    public void testEquals_TwoSentencesPunctuationIgnored_IsFalse() {
        Sentence sentence = new Sentence("I like honey.");
        Sentence sentence1 = new Sentence("i like honey");

        assertFalse(sentence.equals(sentence1));
    }

    @Test
    public void testEquals_IsFalse() {
        Sentence sentence = new Sentence("I like honey.");
        Sentence sentence1 = new Sentence("i like honey");

        assertFalse(sentence1.equals(sentence));
    }

    @Test
    public void testSentencePunctuation() {
        Sentence sentence = new Sentence(".");

        assertEquals(sentence.toString(), "");
    }

    @Test
    public void testEquals_UpperCaseToLowerCaseInMiddle() {
        Sentence sentence = new Sentence("i like Honey and Money.");

        assertEquals(sentence.toString(), "I like honey and money.");
    }

}
