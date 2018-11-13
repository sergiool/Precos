package site.ufsj.precos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PrecosInterface {
    @POST("produto")
    Call<Void> insereProduto(@Body Produto produto);
    @GET("produto")
    Call<List<Produto>> getProduto();
    @GET("produto/{id}")
    Call<Produto> getProdutoPorId(@Path("id") String id);
    @PUT("produto/{id}")
    Call<Void> alteraProduto(@Path("id") String id, @Body Produto produto);
    @DELETE("produto/{id}")
    Call<Void> removeProduto(@Path("id") String id);

    @POST("supermercado")
    Call<Void> insereSupermercado(@Body Supermercado supermercado);
    @GET("supermercado")
    Call<List<Supermercado>> getSupermercado();
    @GET("supermercado/{id}")
    Call<Produto> getSupermercadoPorId(@Path("id") String id);
    @PUT("supermercado/{id}")
    Call<Void> alteraSupermercado(@Path("id") String id, @Body Supermercado supermercado);
    @DELETE("supermercado/{id}")
    Call<Void> removeSupermercado(@Path("id") String id);

    @POST("fabricante")
    Call<Void> insereFabricante(@Body Fabricante fabricante);
    @GET("fabricante")
    Call<List<Fabricante>> getFabricante();
    @GET("fabricante/{id}")
    Call<Produto> getFabricantePorId(@Path("id") String id);
    @PUT("fabricante/{id}")
    Call<Void> alteraFabricante(@Path("id") String id, @Body Fabricante fabricante);
    @DELETE("fabricante/{id}")
    Call<Void> removeFabricante(@Path("id") String id);

    @POST("preco")
    Call<Void> inserePreco(@Body Preco preco);
    @GET("preco")
    Call<List<Preco>> getPreco();
    @GET("preco/{id}")
    Call<Preco> getPrecoPorId(@Path("id") String id);
    @PUT("preco/{id}")
    Call<Void> alteraPreco(@Path("id") String id, @Body Preco preco);
    @DELETE("preco/{id}")
    Call<Void> removePreco(@Path("id") String id);

    @GET("superpreco/{id}")
    Call<List<Superpreco>> getSuperprecoPorId(@Path("id") String id);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.ufsj.site/superbanco.php/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
