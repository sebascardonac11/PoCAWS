import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.transfer.MultipleFileDownload;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;

import java.io.File;
public class DownloadObject {
    public static void main(String[] args) {
        String file_path;
        File f = new File("/home/sebascardonac/Download/object");
        TransferManager xfer_mgr = TransferManagerBuilder.standard().build();
        try {
            Download xfer = xfer_mgr.download("myrawpictures", "100ANDRO/DSC_0002.JPG", f);
            // loop with Transfer.isDone()
            XferMgrProgress.showTransferProgress(xfer);
            // or block with Transfer.waitForCompletion()
            XferMgrProgress.waitForCompletion(xfer);
        } catch (AmazonServiceException e) {
            System.out.println("Error en  main");
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
        xfer_mgr.shutdownNow();
    }
}
