/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package midibox

import com.google.appengine.api.blobstore.BlobKey
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import static org.junit.Assert.*

/**
 *
 * @author soji_2
 */
class GroovyAssistTest {

    public GroovyAssistTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testObjectsArray() {
        Collection sourceCollection = [1, 2, [4, 1, 8], 3, [1, [4, 1], [2, 3, 4], 2], 1, 1];
        int[] destCollection = [1, 2, 4, 1, 8, 3, 1, 4, 1, 2, 3, 4, 2, 1, 1];
        int[] wrongCollection = [1, 2, 3, 1, 8, 3, 1, 4, 1, 2, 3, 4, 2, 1, 1];
        double[] kataCollection = [1, 2, 4, 1, 8, 3, 1, 4, 1, 2, 3, 4, 2, 1, 1];
        
        def result = GroovyAssist.toObjectsArray(sourceCollection);
        
        assertTrue("結果が異常です", destCollection == result);
        assertFalse("変換されてない", sourceCollection == result);
        assertFalse("何故通ったし", wrongCollection == result);
        for (i in 0..destCollection.length - 1) {
            assertFalse("型がおかしい", kataCollection[i].class == result[i].class);
            assertTrue("型が認識されてない", destCollection[i].class == result[i].class);
        }
    }
}
