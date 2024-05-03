package be.thomasmore.appetito.services;


import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class GoogleService {
    /**
     * name of the firebase project - set this prop in application.properties
     */
    @Value("${firebase.bucket.images}")
    private String imageBucket;
    /**
     * credentials for the firebase project = content of the private-key-json file generated
     in firebase.
     * ATTENTION: do not store this value in git!!!!!
     */
    @Value("${firebase.credentials}")
    private String firebaseCredentials;
    /**
     *stores the given file in firebase storage with the given fileName
     * @param file content of this file will be stored in firebase
     * @param fileName name that the file will get in firebase
     * @return the url that can be used to fetch the stored file
     * @throws IOException
     */
    public String toFirebase(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of(imageBucket, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        Storage storage = getFirebaseStorage();
        InputStream inputStream = new FileInputStream(file);
        storage.createFrom(blobInfo, inputStream);
        String DOWNLOAD_URL =
                "https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media";
        return String.format(DOWNLOAD_URL, imageBucket, URLEncoder.encode(fileName,
                StandardCharsets.UTF_8));
    }
    private Storage getFirebaseStorage() throws IOException {
        Credentials credentials = GoogleCredentials.fromStream(new
                ByteArrayInputStream(firebaseCredentials.getBytes()));
        return StorageOptions.newBuilder().setCredentials(credentials).build().getService();
    }
}
