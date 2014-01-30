/*http://wing.w-museum.com/201201251538.html

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package midibox

import com.google.appengine.api.blobstore.BlobKey
import groovy.transform.CompileStatic
/**
 *
 * @author soji_2
 */
@CompileStatic
final class GroovyAssist {
    // ネストしたCollectionを配列化
    static final BlobKey[] toObjectsArray(Collection source) {
        return source.flatten();
    }
}

