
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.lingala.zip4j.core.*;
import net.lingala.zip4j.exception.ZipException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michaeldvinci
 */
public class YaluShore extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public YaluShore() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("JailbreakMe!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("JUST A CONCEPT!!");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        File f = new File("/Users/michaeldvinci/Downloads/yalu-master.zip");
        if (f.exists()) {
            jTextArea1.append("Yalu version exists, deleting and downloading newest version...\n");
            try {
                deleteOldVersion();
            } catch (IOException ex) {
                Logger.getLogger(YaluShore.class.getName()).log(Level.SEVERE, null, ex);
            } catch (net.lingala.zip4j.exception.ZipException ex) {
                Logger.getLogger(YaluShore.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(YaluShore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            jTextArea1.append("Yalu version doesn't exist, downloading newest version.....\n");
            try {
                downloadNewestVersion();
            } catch (IOException ex) {
                Logger.getLogger(YaluShore.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ZipException ex) {
                Logger.getLogger(YaluShore.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(YaluShore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jTextArea1.append("\n");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deleteOldVersion() throws IOException, net.lingala.zip4j.exception.ZipException, InterruptedException {
        Path path = Paths.get("/Users/michaeldvinci/Downloads/yalu-master.zip");
        File path2 = new File("/Users/michaeldvinci/Downloads/yalu-master");
        try {
            Files.delete(path);
            jTextArea1.append("File deleted\n");
        }
        catch (NoSuchFileException x) { jTextArea1.append("Trouble deleting, try again!\n"); }
        try {
            File[] contents = path2.listFiles();
            if (contents != null) {
                for (File f : contents) {
                    deleteDir(path2);
                }
            }
            path2.delete();
            jTextArea1.append("Old Folder deleted\n");
        }
        catch ( Exception e ) {}
        downloadNewestVersion();
    }
    
    void deleteDir(File file) {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                deleteDir(f);
            }
        }
        file.delete();
    }
    
    private void downloadNewestVersion() throws IOException, net.lingala.zip4j.exception.ZipException, InterruptedException {
        URL url = new URL("https://github.com/kpwn/yalu/archive/master.zip");
        String localFilename = "/Users/michaeldvinci/Downloads/yalu-master.zip";
        
        jTextArea1.append("Downloading!\n");
        downloadFromUrl(url, localFilename);
        jTextArea1.append("Downloaded!\n");
        
        String source = "/Users/michaeldvinci/Downloads/yalu-master.zip";

        ZipFile zipf = new ZipFile(source);
        zipf.extractAll("/Users/michaeldvinci/Downloads/");
        
        executeScript();
    }
    
    void downloadFromUrl(URL url, String localFilename) throws IOException {
        
        try {
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();
            FileOutputStream out = new FileOutputStream(localFilename);
            byte[] b = new byte[1024];
            int count;
            while ((count = in.read(b)) >= 0) {
                out.write(b, 0, count);
            }
            out.flush(); out.close(); in.close();                   

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void executeScript() throws IOException, InterruptedException {
        jTextArea1.append("Setting permissions...\n");
        Runtime.getRuntime().exec( "chmod -R 777 /Users/michaeldvinci/Downloads/yalu-master/" );
        jTextArea1.append("Starting Yalu's run.sh\n");
        
        ProcessBuilder pb = new ProcessBuilder("/Users/michaeldvinci/Downloads/yalu-master/stage0.sh");
        pb.redirectOutput(Redirect.INHERIT);
        pb.redirectError(Redirect.INHERIT);
        Process p = pb.start();     // Start the process. 
        
        //Process p = Runtime.getRuntime().exec("/Users/michaeldvinci/Downloads/yalu-master/stage0.sh");
        InputStream lsOut = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(lsOut);
        BufferedReader r = new BufferedReader(isr);

        String line;
        
        PrintWriter pw = new PrintWriter(p.getOutputStream());
        
        while ((line = r.readLine())!=null) {
            jTextArea1.append(line);
            p.waitFor();
            System.out.println(line);
        }
        
        System.out.println("Script executed successfully");
        
        r.close();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(YaluShore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YaluShore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YaluShore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YaluShore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YaluShore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
