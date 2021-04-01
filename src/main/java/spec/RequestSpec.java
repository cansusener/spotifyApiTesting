package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    RequestSpecification requestSpecification;

    private String baseUrl = "https://api.spotify.com";
    private String mytoken = "BQBjeL_isy6WfE2WeTt9_bdwCdY8fh9BTCMahHnIv0v0qfwXv774MzTjmif-QAEF2Q5CPy11TmxvqwI6WBV9HyJ5kjnJLgrevZ4NjWDq8IuPpdf9XPEl3vC5YPWcx2N4_gJEYbFDD4XnRE2Ek-B8E5ZG7QcIIGLsH7pvRWX6DSHNBBDIj_Q2Je6-QBqZrtsVigl_J-BdrkwRG7Qd0AA0jTeqlziVmIl_VxX91ti-2qvcxevw0tjiyKiJQwSS9H_kqd58MA1kFyXzA8qvaMJ07Po";

    public RequestSpec(String endPoint) {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl+endPoint)
                .addHeader("Authorization","Bearer " +mytoken)
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

}
