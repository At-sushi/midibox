/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package midibox;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
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
            if (request.getUserPrincipal() == null)
                response.sendRedirect("/");
            else {
                processBlob(blob.get(0));
            }

            // まだテスト中なので削除する設定
            // groovy使えば良かった… 移行も検討
            blobstore.delete((BlobKey[])blob.toArray());
        }
        else {
            response.getWriter().println("ファイル情報がないっす");
        }
    }
    
    private boolean processBlob(BlobKey blob) {
        // void
        return false;
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