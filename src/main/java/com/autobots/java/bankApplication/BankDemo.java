package com.autobots.java.bankApplication;

public class BankDemo {
    public static void main(String[] args) throws Exception {

        Mbank izatMbank = new Mbank(123456789111L,444444444);

        System.out.println(izatMbank.getBalance());

        izatMbank.deposit(200000);
        System.out.println("______________");
        System.out.println(izatMbank.getBalance());


        OptimaBank alyaOptima = new OptimaBank(123456789121L,555555555);
        System.out.println(alyaOptima.getBalance());
        System.out.println("______________");

        Bank.transferFunds(izatMbank,alyaOptima,5000);
        System.out.println(alyaOptima.getBalance());
        System.out.println(izatMbank.getBalance());
        System.out.println("_________________");

        DemirBank zinaidaDemirBank = new DemirBank(123456789123L,666666666);
        Bank.transferFunds(zinaidaDemirBank,alyaOptima,500);
        System.out.println(zinaidaDemirBank.getBalance());
        System.out.println(alyaOptima.getBalance());

    }
}
