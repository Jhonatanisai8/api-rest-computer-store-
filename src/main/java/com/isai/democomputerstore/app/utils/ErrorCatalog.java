package com.isai.democomputerstore.app.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

    PRODUCT_NOT_FOUND("ERR_PROD_001", "Product not found"),
    INVALID_PRODUCT("ERR_PROD002", "Invalid product parameters"),
    MAKER_NOT_FOUND("ERR_MAKER001", "Maker not found"),
    GENERIC_ERROR("ERR_GEN001", "An unexpected error occurred"),
    UNAUTHORIZED_ERROR("ERR_GEN002", "No Unauthorized access"),
    ;

    private final String codeError;
    private final String messageError;

    private ErrorCatalog(String codeError, String messageError) {
        this.codeError = codeError;
        this.messageError = messageError;
    }
}
