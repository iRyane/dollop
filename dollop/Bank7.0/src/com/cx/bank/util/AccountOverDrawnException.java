package com.cx.bank.util;
//import java.io.*;

public class AccountOverDrawnException extends Exception{

    public AccountOverDrawnException(){
        super("取款超出余额！");
    }
}
