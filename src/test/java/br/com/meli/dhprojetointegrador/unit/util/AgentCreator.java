package br.com.meli.dhprojetointegrador.unit.util;

import br.com.meli.dhprojetointegrador.entity.Agent;

public class AgentCreator {

  public static Agent createValidAgent() {
    return Agent.builder()
        .name("Agente")
        .warehouse(WarehouseCreator.createValidWarehouse())
        .password("1234")
        .id(1L)
        .build();
  }

}
