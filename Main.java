package com.company;

public class Main {

    public static void main(String[] args) {
        Human james = new Human("James","19/2/1965","Nam");
        Human hana = new Human("Hana","30/7/1975","Nữ");
        Human ryan = new Human("Ryan","21/5/1990","Nam");       //kết hôn vs jeni
        Human kai = new Human("Kai","13/6/1995","Nam");         //độc thân
        Human jenifer = new Human("Jenifer","12/7/1996","Nữ");
        Human jackson = new Human("Jackson","19/1/2005","Nam");
        Human Lina = new Human("Lina","5/8/2008","Nữ");
        Human Tracy = new Human("Tracy","31/12/2010","Nữ");
        Human taylor = new Human("Taylor","1/12/2011","Nữ");

        james.getMarried(hana);
        james.addChild(ryan);
        james.addChild(kai);
        kai.getMarried(jenifer);
        kai.addChild(jackson);
        kai.addChild(Lina);
        kai.addChild(Tracy);
        kai.addChild(taylor);
        //moi thu deu duoc tinh tu to tien
        //tim nguoi doc than trong pha he
        System.out.println("-Nhung nguoi doc than la:");
        for(int i =0; i < james.findNotMarriedChildren().size(); i++) {
            System.out.println("\t"+james.findNotMarriedChildren().get(i));
        }
        //tim ngoui co hai con trong pha he
        System.out.println("-Cac cap co hai con la:");
        for(int i =0; i < james.findHasTwoChildren().size(); i++) {
            System.out.println("\t"+james.findHasTwoChildren().get(i));
        }
        //tim the he moi nhat
        System.out.println("-The he moi nhat la:");
        for(int i =0; i < james.getNewestGeneration().size(); i++) {
            System.out.println("\t"+james.getNewestGeneration().get(i));
        }
    }
}
