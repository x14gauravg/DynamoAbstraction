package com.gauravg.dynamo.helper;


import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.extensions.annotations.DynamoDbVersionAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

@Data
@ToString
@Table(name = "ACCOUNT")
@DynamoDbBean
public class FakeStudent {

    // Department
    @PartitionKey
    private String PARTITION_KEY;

    @SortKey
    private String SORT_KEY;

    private Integer fees;
    private String ID;
    private String STUDENT_NAME;
    private FakePicture img;
    private Integer version;


    @DynamoDbVersionAttribute
    public Integer getVersion() {
        return version;
    }


    @DynamoDbPartitionKey
    public String getPARTITION_KEY() {
        return PARTITION_KEY;
    }

    @DynamoDbSortKey
    public String getSORT_KEY() {
        return SORT_KEY;
    }

}


