package com.ZenPack.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ErrorResponseTest {

    @Test
    void testConstructor() {
        ErrorResponse actualErrorResponse = new ErrorResponse(HttpStatus.CONTINUE, "Not all who wander are lost");
        actualErrorResponse.setMessage("Not all who wander are lost");
        actualErrorResponse.setStatus(HttpStatus.CONTINUE);
        assertEquals("Not all who wander are lost", actualErrorResponse.getMessage());
        assertEquals(HttpStatus.CONTINUE, actualErrorResponse.getStatus());
    }
}

