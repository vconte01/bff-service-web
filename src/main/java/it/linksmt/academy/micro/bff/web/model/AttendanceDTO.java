package it.linksmt.academy.micro.bff.web.model;

import java.util.ArrayList;
import java.util.List;

public class AttendanceDTO {

    private String nome;
    private List<String> courses;

    public AttendanceDTO() {
       this.courses= new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }



    public void addCourse(String course) {

        this.courses.add(course);

    }



}
