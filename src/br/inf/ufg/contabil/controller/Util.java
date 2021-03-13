package br.inf.ufg.contabil.controller;

import java.time.LocalDateTime;

public class Util {

  public static int getDiaAtual(){
    return LocalDateTime.now().getDayOfMonth();
  }


  private Util() {
    super();
  }  


}
