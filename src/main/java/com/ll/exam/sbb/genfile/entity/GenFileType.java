package com.ll.exam.sbb.genfile.entity;

public enum GenFileType {
    ARTICLE(Values.ARTICLE), MEMBER(Values.MEMBER);

    private GenFileType(String val) {
        // force equality between name of enum instance, and value of constant
        if (!this.name().equals(val))
            throw new IllegalArgumentException("Incorrect use of FileType");
    }

    public static class Values {
        public static final String ARTICLE = "ARTICLE";
        public static final String MEMBER = "MEMBER";
    }
}