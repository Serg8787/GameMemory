package com.tsybulnik.gamememory;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("?token=af10be13c903c7")
    Call<Model> loadData();
}
