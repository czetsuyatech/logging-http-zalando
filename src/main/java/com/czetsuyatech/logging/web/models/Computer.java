package com.czetsuyatech.logging.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Computer {

  private String brand;
  private String model;
  private int ram;
  private String cpu;
}
