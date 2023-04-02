package com.example.Resource_service.repository;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.io.InputStream;

@Component
public class S3repository {
    private static final String BUCKET = "my-bucket-name";
    private S3Client s3Client;

    public S3repository() {
        this.s3Client = S3Client.builder().build();
    }

    public void uploadFile(String fileName, InputStream inputStream)
            throws AwsServiceException, IOException {

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(BUCKET)
                .key(fileName)
                .build();

        s3Client.putObject(request,
                RequestBody.fromInputStream(inputStream, inputStream.available()));

    }

    public byte[] downloadFile(String fileName) throws Exception{
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(BUCKET)
                .key(fileName)
                .build();

        var object= s3Client.getObject(getObjectRequest);
        return object.readAllBytes();
    }

    public void deleteObject(String fileName){
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(BUCKET)
                .key(fileName)
                .build();

        s3Client.deleteObject(deleteObjectRequest);
    }
}
