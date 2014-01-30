package midibox;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PMF {
    private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private PMF() {}

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }
    
    // ここで実装すべきではないような気もするが…
    public static void discardObject(IDiscardNeeded obj) {
        obj.discard();
        pmfInstance.getPersistenceManager().deletePersistent(obj);
    }
}
