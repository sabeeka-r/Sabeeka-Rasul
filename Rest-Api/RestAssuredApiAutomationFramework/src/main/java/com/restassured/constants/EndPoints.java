package com.restassured.constants;

public class EndPoints {

    public static final String ADD_NEW_PET = "/api/v3/pet";
    public static final String GET_PET_BY_STATUS = "/api/v3/pet/findByStatus";
    public static final String GET_PET_BY_TAG = "/api/v3/pet/findByTags";
    public static final String GET_PET_BY_ID = "/api/v3/pet/{ID}";
    public static final String UPDATE_PET_BY_ID = "/api/v3/pet/{petId}";
    public static final String UPLOAD_PET_IMAGE = "/api/v3/pet/{petId}/uploadImage";
    public static final String DELETE_BY_PET_ID = "/api/v3/pet/{petId}";

}
