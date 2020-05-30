package com.Amazon.services.sendMessage;



import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.PackagePrivate;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
//import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.converter.jackson.JacksonConverterFactory;

@ToString
@Accessors(fluent = true)
public class LINEClient {
   // private static final ObjectMapper objectMapper = modelObjectMapper.getNewObjectMapper();
	
  /*  @PackagePrivate
    LINEClient() {
    }*/
    
    
    public LINEClient() {
		super();
	}


	private URI apiEndPoint = APIConfiguration.API_BASE_URL;


    // We can remove this after delete `setApiEndPoint(String apiEndPoint)`.
    public LINEClient apiEndPoint(URI apiEndPoint) {
        this.apiEndPoint = requireNonNull(apiEndPoint, "apiEndPoint");
        return this;
    }

    @Setter
    private long connectTimeout = APIConfiguration.CONNECT_TIMEOUT_MILLIS;
    @Setter
    private long readTimeout = APIConfiguration.READ_TIMEOUT_MILLIS;
    @Setter
    private long writeTimeout = APIConfiguration.WRITE_TIMEOUT_MILLIS;
    @Setter
    private String channelAccessToken;
    @Setter
    private Retrofit.Builder retrofitBuilder;
    
    private OkHttpClient.Builder okHttpClientBuilder;


    public LINEClient channelAccessToken(String channelAccessToken) {
        this.channelAccessToken=channelAccessToken;
        return this;
    }

   
    public LINEClient okHttpClientBuilder(final @NonNull OkHttpClient.Builder okHttpClientBuilder) {
        this.okHttpClientBuilder = okHttpClientBuilder;
        return this;
    }

    
    <T> T buildRetrofitIface(URI apiEndPoint, Class<T> retrofitIFace) {
        if (okHttpClientBuilder == null) {
            okHttpClientBuilder = new OkHttpClient.Builder();
        }

        // Add interceptors.
       
        	okHttpClientBuilder.addInterceptor(authenticationInterceptor(channelAccessToken));
        
       
      //  okHttpClientBuilder.addInterceptor(buildLoggingInterceptor());

        // Set timeout.
        okHttpClientBuilder
                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS);

        final OkHttpClient okHttpClient = okHttpClientBuilder.build();

        if (retrofitBuilder == null) {
            retrofitBuilder = createRetrofitBuilder();
        }
        retrofitBuilder.client(okHttpClient);
        retrofitBuilder.baseUrl(apiEndPoint.toString());

        final Retrofit retrofit = retrofitBuilder.build();

        return retrofit.create(retrofitIFace);
    }

    static Interceptor authenticationInterceptor(String channelAccessToken) {
        requireNonNull(channelAccessToken, "channelAccessToken");
        return new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization","Bearer " + channelAccessToken);

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        };
    }
    
   

    static Retrofit.Builder createRetrofitBuilder() {
        return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create());
    }

    
    public sendService build() {
    	return new sendService(buildRetrofitIface(apiEndPoint, messagesend.class));
    }

    
}
