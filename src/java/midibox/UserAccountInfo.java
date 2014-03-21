/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package midibox;

import java.util.List;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author soji_2
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class UserAccountInfo {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long ID;
    
    @Persistent
    private String loginID;
    
    @Persistent
    private byte[] password;
    
    @Persistent(mappedBy = "author")
    private List<MidiDataInfo> midiDatas;
}
