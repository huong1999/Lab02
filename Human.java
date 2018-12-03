package com.company;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;                 //tên
    private String birthdate;           //ngày tháng sinh
    private String sex;                 //sex
    private List<Human> children;       //con cái
    private Human spouse;               //cặp vợ chồng
    private boolean isMarried;          //đã kết hôn
    private boolean hasChildren;       //đã có con
    private int generation;             //thế hệ

    {
        this.name = null;
        this.spouse = null;
        this.isMarried = false;
        this.hasChildren = false;
        this.birthdate = null;
        this.sex = null;
        this.children = new ArrayList<>();
        this.generation = 0;
    }

    public Human(String name, String birthdate, String sex) {
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
    }

    public void getMarried(Human spouse) {
        this.isMarried = true;
        this.spouse = spouse;
    }

    public void addChild(Human child) {
        children.add(child);
        this.hasChildren = true;
    }

    //khoi tao thu tu cua the he trong cay pha he
    public void generateGeneration() {
        for(int i =0; i < this.children.size(); i++) {
            this.children.get(i).setGeneration(this.generation-1);
            this.children.get(i).generateGeneration();
        }
    }

    //tim nhung nguoi chua ket hon
    public List<Human> notMarriedChildren() {
        List<Human> result = new ArrayList<>();
        // neu da ket hon roi
        if(this.isMarried==true) {
            //thi tim nhung nguoi chua ket hon o cac the he con chau
            if(this.hasChildren==true) {      //xét con

                for(int i =0; i < this.children.size(); i++) {
                    List<Human> response = this.children.get(i).notMarriedChildren();
                    if(response.isEmpty()==false)
                        for(int j =0; j < response.size(); j++) {
                            result.add(response.get(j));
                        }
                }
            }
            return result;
        }
        // neu chua ket hon thi them nguoi nay vao
        result.add(this);
        return result;
    }

    public List<Human> hasTwoChildren() {
        List<Human> result = new ArrayList<>();
        //neu da ket hon roi
        if(this.isMarried) {
            if(this.hasChildren) {
                //neu co so luong con de la 2 thi them vao
                if(this.children.size() == 2) result.add(this);
                //tim cac nguoi co 2 con o the he con chau
                for(int i =0; i < this.children.size(); i++) {
                    List<Human> response = this.children.get(i).hasTwoChildren();
                    if(response != null && !response.isEmpty()) {
                        for(int j =0; j < response.size(); j++) {
                            result.add(response.get(j));
                        }
                    }
                }
            }
            return result;
        }
        //neu chua ket hon thi chua co con tra ve null
        return null;
    }

    //lay the he moi nhat
    public List<Human> getNewestGeneration(){
        List<Human> result = new ArrayList<>();
        // khoi tao thu tu the he
        this.generateGeneration();
        //tim nhung nguoi chua ket hon vi the he moi nhat luon chua ket hon
        List<Human> response = this.notMarriedChildren();
        int min = this.generation;
        //tim thu tu moi nhat cua the he
        for(int i =0; i< response.size(); i++) {
            if(response.get(i).getGeneration() < min)
                min = response.get(i).getGeneration();
        }
        //tim the he moi nhat trong danh sach nhung nguoi chua ket hon
        for(int i =0; i< response.size(); i++) {
            if(response.get(i).getGeneration() == min)
                result.add(response.get(i));
        }
        return result;
    }

    @Override
    public String toString() {
        if(spouse == null)
            return this.name + " " + this.birthdate + " " + this.sex;
        else
            return this.name + " " + this.birthdate + " " + this.sex + " va " +
                    this.spouse.getName() +" "+ this.spouse.getBirthdate() +" "+ this.spouse.getSex();
    }

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getSex() {
        return sex;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

}