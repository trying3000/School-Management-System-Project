package com.company;

public class Class {

    public String className;
    public String courseCode;
    public int classStrength;
    public static int classesCount = 0;

    public Class(String className,String courseCode,int classStrength){

        this.className = className;
        this.courseCode = courseCode;
        this.classStrength = classStrength;
        classesCount++;
    }
}
