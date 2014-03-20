/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package midibox;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Text;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author soji_2
 */
public class UploadServlet extends HttpServlet {
    private BlobstoreService blobstore = BlobstoreServiceFactory.getBlobstoreService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/");
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, List<BlobKey>> bloblist = blobstore.getUploads(request);
        List<BlobKey> blob = bloblist.get("source");
            
        if (blob != null) {
            // ログイン確認用フィルター
            if (false)
                response.sendRedirect("/");
            else {
                processBlob(request, blob.get(0));
                return;
            }
        }
        else {      // ブロブが投稿されてない
            response.getWriter().println("ファイル情報がないっす");
        }

        // まだテスト中なので削除する設定
        blobstore.delete(GroovyAssist.toObjectsArray(bloblist.values()));
        assert(blobstore.getUploads(request).isEmpty());
    }
    
    private boolean processBlob(HttpServletRequest request, BlobKey blob) {
        // void
        MidiDataInfo mi = new MidiDataInfo((String) request.getParameter("dataname"), blob, null);
        PersistenceManager pmf = PMF.get().getPersistenceManager();
        
        mi.comment = new Text((String)request.getParameter("commentText"));
        
        try {
            pmf.makePersistent(mi);
       } finally {
            pmf.close();
        }
        
        return true;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "New File Upload";
    }// </editor-fold>
}
