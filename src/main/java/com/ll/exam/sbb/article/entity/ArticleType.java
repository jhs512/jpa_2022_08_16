package com.ll.exam.sbb.article.entity;

public enum ArticleType {
    FREE(Values.FREE), NOTICE(Values.NOTICE);

    private ArticleType(String val) {
        // force equality between name of enum instance, and value of constant
        if (!this.name().equals(val))
            throw new IllegalArgumentException("Incorrect use of ArticleType");
    }

    public static class Values {
        public static final String FREE = "FREE";
        public static final String NOTICE = "NOTICE";
    }
}