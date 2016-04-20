package referencelibrary.data;

import org.junit.Before;
import org.junit.Test;
import referencelibrary.reference.BookReference;
import referencelibrary.reference.Reference;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by petri on 18.4.2016.
 */
public class StubDaoTest {
    private StubDao refs;

    @Before
    public void setUp() {
        refs = new StubDao();
    }

    @Test
    public void listAll() {
        List<Reference> reflist = refs.listAll();
        assertEquals(1, reflist.size());
        assertEquals("REF", reflist.get(0).getReferenceName());
    }

    @Test
    public void add() {
        refs.add(new BookReference());
        refs.listAll().get(1).setReferenceName("REF1");
        List<Reference> reflist = refs.listAll();
        assertEquals("REF1", reflist.get(1).getReferenceName());
    }

    @Test
    public void remove() {
        String referenceName = "remove_me";
        List<Reference> reflist;

        Reference ref = new BookReference();
        ref.setReferenceName(referenceName);
        refs.add(ref);

        reflist = refs.listAll();
        assertEquals(referenceName, reflist.get(1).getReferenceName());

        refs.remove(referenceName);
        reflist = refs.listAll();
        assertEquals(1, reflist.size());
        assertNotEquals(referenceName, reflist.get(0).getReferenceName());
    }

}