package com.cx.bank.util;
//import java.io.*;

public class InvalidDepositException extends Exception{
    public InvalidDepositException()
    {
        super("充值为负数！");
    }
}
