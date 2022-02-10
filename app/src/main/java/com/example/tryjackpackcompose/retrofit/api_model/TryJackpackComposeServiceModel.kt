package com.example.tryjackpackcompose.retrofit.api_model

import com.example.tryjackpackcompose.entity.UserToken
import com.example.tryjackpackcompose.retrofit.response.project.ProjectDetailResponse
import com.example.tryjackpackcompose.retrofit.response.project.ProjectSummaryResponse
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface TryJackpackComposeServiceModel {
//    @Headers()
    @Headers(
        "Cache-Control: no-cache",
        "Authorization: Basic ZXhjZWwtYXBpOmV4Y2VsLXNlY3JldA=="
    )
    @FormUrlEncoded
    @POST("/xTrack/api/oauth/token")
    fun getUserInfo(@FieldMap() fields: Map<String, String> ): Observable<UserToken>

    @POST("/xTrack/api/getProjectsBriefDelta")
    fun getProjectBriefDelta(@Body body: RequestBody): Observable<ProjectSummaryResponse>

    @POST("/xTrack/api/getProjectFullDelta")
    fun getFullProjectData(@Body body: RequestBody): Observable<ProjectDetailResponse>

//    @PUT("/turkey/userinfo/{userId}/")
//    fun updateUserInfo(@Path("userId") userId: String, @Body body: RequestBody): Observable<UserInfo>
//
//    @DELETE("/turkey/login/{userId}/")
//    fun logout(@Path("userId") userId: String): Observable<Response<Any>>
//
//    // Convert Rate
//    @GET("/turkey/rate/")
//    fun getConvertRate(): Observable<ConvertRate>
//
//    // Order History
//    @GET("/turkey/sell-order-history/")
//    fun getOrderHistory(@Query("page") page: Int, @Query("status") status: String): Observable<PagableResponse<Order>>
//
//    @PUT("/turkey/sell-order-history/{sell-order_history_id}/")
//    fun updateSellOrderStatus(@Path("sell-order_history_id") sellOrderHistoryId: String,
//                              @Body body: RequestBody): Observable<Order>
//
//    // FOR BUYER
//
//    @POST("/turkey/take-sell-order/")
//    fun takeSellOrder(@Body body: RequestBody): Observable<Order>
//
//    @POST("/turkey/buy-order/")
//    fun createBuyOrder(@Body body: RequestBody): Observable<Order>
//
//    @PUT("/turkey/buy-order/{id}/")
//    fun cancelBuyOrder(@Path("id") buyOrderId: String): Observable<Order>
//
//    @GET("/turkey/is-able-to-buy/")
//    fun checkIsAbleToTakeSellOrder(): Observable<TurkeyResultResponse<Boolean>>
//    // END BUYER
//
//    // FOR SELLER
//
//    @POST("/turkey/take-buy-order/")
//    fun takeBuyOrder(@Body body: RequestBody): Observable<Order>
//
//    @POST("/turkey/sell-order/")
//    fun createSellOrder(@Body body: RequestBody): Observable<Order>
//
//    @PUT("/turkey/sell-order/{id}/")
//    fun cancelSellOrder(@Path("id") buyOrderId: String): Observable<Order>
//    // END SELLER
//
//    // FOR BOTH BUYER SELLER
//
//    @GET("/turkey/buy-order/")
//    fun getBuyOrderList(@Query("page") page: Int, @Query("status") status: String?): Observable<PagableResponse<Order>>
//
//    @GET("/turkey/sell-order/")
//    fun getSellOrderList(@Query("page") page: Int, @Query("status") status: String?): Observable<PagableResponse<Order>>
//    // END FOR BOTH BUYER SELLER
//
//    @GET("turkey/sell-order-history/{id}/")
//    fun getOrderDetails(@Path("id") id: String): Observable<Order>
//
//    // PAYMENT METHODS
//
//    // GET PAYMENT LIST
//    @GET("/turkey/payment-method/")
//    fun getPaymentMethod(@Query("page") page: Int,
//                         @Query("is_active") isActive: Boolean?,
//                         @Query("type") paymentTypes: String?): Observable<PagableResponse<PaymentMethod>>
//
//    // ADD PAYMENT
//    @POST("/turkey/payment-method/")
//    fun addPaymentMethod(@Body body: RequestBody): Observable<PaymentMethod>
//
//    // CHANGE ACTIVE STATE
//    @PUT("/turkey/payment-method/{payment_id}/")
//    fun changePaymentMethodActiveState(@Path("payment_id") paymentID:Int, @Body body: RequestBody): Observable<PaymentMethod>
//
//    // GET ORDER PAYMENT METHODS
//    @GET("/turkey/payment-method/")
//    fun getOrderPaymentMethods(@Query("sell_order_history_id") sellOrderHistoryId: String, @Query("page")page: Int): Observable<PagableResponse<PaymentMethod>>
//
//    // END PAYMENT METHODS
//
//    // USDT
//
//    // WITHDRAW USDT
//    @POST("/turkey/withdraw/")
//    fun withdrawUsdt(@Body body: RequestBody): Observable<Any>
//
//    // GET DEPOSIT ADDRESS
//    @GET("/turkey/address/")
//    fun getDepositAddress(): Observable<UsdtAddress>
//
//    //END USDT
//
//    // FUND HISTORY
//
//    @GET("/turkey/fund-history/")
//    fun getFundHistory(@Query("status") status: Int?, @Query("page") page: Int): Observable<PagableResponse<FundHistory>>

    // END FUND HISTORY
}