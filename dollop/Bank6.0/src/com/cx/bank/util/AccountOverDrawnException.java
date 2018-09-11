package com.cx.bank.util;
//import java.io.*;

public class AccountOverDrawnException extends Exception{

    public AccountOverDrawnException(){
        super("支付超出余额！");
    }
}
