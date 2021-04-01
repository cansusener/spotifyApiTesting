package spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class ResponseSpec {
    public static ResponseSpecification checkStatusCode(int statusCode) {
        switch (statusCode){
            case(HttpStatus.SC_OK) :
                return new ResponseSpecBuilder()
                        .expectStatusCode(HttpStatus.SC_OK)
                        .build();
            case(HttpStatus.SC_CREATED):
                return new ResponseSpecBuilder()
                        .expectStatusCode(HttpStatus.SC_CREATED)
                        .build();
            case(HttpStatus.SC_UNAUTHORIZED):
                return new ResponseSpecBuilder()
                        .expectStatusCode(HttpStatus.SC_UNAUTHORIZED)
                        .build();
            case(HttpStatus.SC_BAD_REQUEST):
                return new ResponseSpecBuilder()
                        .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
                        .build();
            case(HttpStatus.SC_NOT_FOUND):
                return new ResponseSpecBuilder()
                        .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                        .build();
        }
        return null;
    }
}
