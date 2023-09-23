package com.samyak.constants;

public class SQLConstants {
    public static final String SELECT_PRODUCT_NAME_AND_DESCRIPTION_INDEX = "SELECT p FROM Product p WHERE p.name=?1 AND p.description=?2";

    public static final String SELECT_PRODUCT_NAME_AND_DESCRIPTION_NAMED = "SELECT p FROM Product p WHERE p.name=:name AND p.description=:description";

    public static final String SELECT_PRODUCT_NAME_AND_DESCRIPTION_NATIVE_INDEX = "SELECT * FROM product p WHERE p.name=?1 AND p.description=?2";
    public static final String SELECT_PRODUCT_NAME_AND_DESCRIPTION_NATIVE_NAMED = "SELECT * FROM product p WHERE p.name=:name AND p.description=:description";
}
