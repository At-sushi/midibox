/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package midibox;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;
import java.util.Date;

/**
 *
 * @author soji_2
 * 
 * MIDIデータ用クラス
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class MidiDataInfo implements IDiscardNeeded {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long ID;
    
    @Persistent
    private User author;        // 暫定。型は専用のJDOクラスに変える可能性有り。
    
    @Persistent
    private String name;
    
    @Persistent
    private Date lastModified;
    
    @Persistent
    private Date length;
    
    @Persistent
    private BlobKey data;

    public void updateData(BlobKey newData) {
        discard();
        data = newData;
    }
    
    // データが消えるときの処理
    @Override
    public void discard() {
        // ブロブのデータを削除
        BlobstoreServiceFactory.getBlobstoreService().delete(data);
    }
}
