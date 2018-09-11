package com.cx.bank.util;
//import java.io.*;

public class InvalidDepositException extends Exception{
    public InvalidDepositException()
    {
        super("存款为负数！");
    }
}
