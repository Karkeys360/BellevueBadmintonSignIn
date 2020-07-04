package com.BBCSignin;

public class Member {
    private String FirstName;
    private String LastName;
    private String FamilyName;
    private int Barcode;


    public Member(String[] details) {
        FirstName = details[0];
        LastName = details[1];
        FamilyName = details[2];
        //System.out.println(Integer.parseInt(details[5]));
        int Barcode = Integer.parseInt(details[5]);
        //System.out.println(Barcode);
    }

    public String getFirstName( ) {
        return FirstName;
    }

    public String getLastName( ) {
        return LastName;
    }

    public String getFamilyName( ) {
        return FamilyName;
    }

    public int getBarcode( ) {
        return Barcode;
    }
}


