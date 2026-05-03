package com.univ_java_task_7.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Railcar {
    private Long railcar_num;
    private String railcar_type;
    private Double railcar_capacity_tons;
    private String railcar_owner_company;
}
