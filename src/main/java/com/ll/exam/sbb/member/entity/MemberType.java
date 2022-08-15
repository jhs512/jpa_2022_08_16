package com.ll.exam.sbb.member.entity;

public enum MemberType {
    ADMIN(Values.ADMIN), NORMAL(Values.NORMAL);

    private MemberType(String val) {
        // force equality between name of enum instance, and value of constant
        if (!this.name().equals(val))
            throw new IllegalArgumentException("Incorrect use of MemberType");
    }

    public static class Values {
        public static final String ADMIN = "ADMIN";
        public static final String NORMAL = "NORMAL";
    }
}