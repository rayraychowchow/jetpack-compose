package com.example.tryjackpackcompose.retrofit.interceptor

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
//import com.hec.turkey.otc.ext.tryParse
//import com.hec.turkey.otc.retrofit.exceptions.*
import okhttp3.*
import okio.Buffer
import java.io.IOException
import java.util.*

class LoggingInterceptor : BaseInterceptor() {

    val gson = Gson()
    val type = object : TypeToken<List<String>>() {}.type

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val t1 = System.nanoTime()
//        logger.i(
//            "LoggingInterceptor t1 - :" + String.format(
//                "Sending request %s on %s%n%s",
//                request.url(), chain.connection(), request.headers()
//            )
//        )

        if (request.method().equals("POST", true)) {
            val body = request.body()
            println(body)
//            logger.i(
//                "LoggingInterceptor POST body - :" + String.format(
//                    "Sending request %s body: %s",
//                    request.url(), requestBodyToString(body)
//                )
//            )

        }

        val response = chain.proceed(request)
        var body = "null"

//        logger.i(
//            "LoggingInterceptor POST response - :"
//                    + if (response.isSuccessful) "Successful" else "not Successful"
//        )

        response.body()?.let {
            body = it.string()
        }

        val t2 = System.nanoTime()
//        logger.i(
//            "LoggingInterceptor t2 - :" + String.format(
//                Locale.TRADITIONAL_CHINESE,
//                "Received response for %s in %.1fms%n%s%s",
//                response.request().url(), (t2 - t1) / 1e6, "", body
//            )
//        ) // ignore response header first
        //                response.request().url(), (t2 - t1) / 1e6d, response.headers(), body));

        if (!response.isSuccessful) {
            validateDjangoError(request, body, response.code())
        }

        return if (response.body() == null) {
            response
        } else {
            response.newBuilder()
                .body(ResponseBody.create(response.body()!!.contentType(), body))
                .build()
        }

    }

    @Throws(IOException::class)
    private fun requestBodyToString(requestBody: RequestBody?): String {
        val buffer = Buffer()
        requestBody?.writeTo(buffer)
        return buffer.readUtf8()
    }

    private fun validateDjangoError(request: Request, body: String, status: Int) {
//        val path = request.url().encodedPath()
//
//        // special handle to collect heart beat api
////        if (path.contains("agent-hbp")) {
//        if (body.contains("有未确认的订单")) {
//            throw DjangoActiveOrderException(path, "有未确认的订单")
//        }
//
//        if (body.contains("请保持文件大小少于")) {
//            throw DjangoImageUploadOrderException(path, body.replace("[\"", "").replace("\"]", ""))
//        }
//
//        if (body.contains("付款方式已经存在")) {
//            throw DjangoAddPaymentMethodException(path, "付款方式已经存在")
//        }
//
//        if (body.contains("USDT余额不足")) {
//            throw DjangoUsdtNotEnoughException(path, "USDT余额不足")
//        }
//
//        if (body.contains("资金密码错误")) {
//            throw DjangoFundPasswordException(path, "资金密码错误")
//        }
//
//        if (body.contains("金额过细, 不足创单")) {
//            throw DjangoCreateOrderAmountException(path, "金额过细, 不足创单")
//        }
//
//        val detailError = gson.tryParse<DjangoMessage>(body, DjangoMessage.GSON_TYPE)
//        if (detailError.first) {
//            detailError.second?.message?.let {
//                throw DjangoException(path, it)
//            }
//        }
//
//        val errors = gson.tryParse<List<String>>(body, type)
//        if (errors.first) {
//            errors.second?.firstOrNull()?.let {
//                throw DjangoException(path, it)
//            }
//        }
    }
}
