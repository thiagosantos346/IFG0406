package br.inf.domain;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Categoria {
  SIMPLES("SIMPLES"),
  EXECUTIVA("EXECUTIVA"),
  PREMIUN("PREMIUN"),
  PERSONALITE("PERSONALITE");

  private String name;
  private static final Map<String, Categoria> CATEGORIA_MAP;

  Categoria(String name){
    this.name  = name.toUpperCase();
  }
  
  public String getName(){
    return this.name;
  }

  static {
    Map<String, Categoria> map = new ConcurrentHashMap<String, Categoria>();
    for(Categoria instance : Categoria.values()){
      map.put(instance.getName().toUpperCase(), instance);
    }

    CATEGORIA_MAP = Collections.unmodifiableMap(map);

  }

  public static Categoria get(String name){
    return CATEGORIA_MAP.get(name.toUpperCase());
  }

}
