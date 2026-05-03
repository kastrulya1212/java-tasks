package com.univ_java_task_6.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RailcarOperation {
    private Long id;
    private Long railcar_num;
    private String operation_type;
    private String operation_status;
    private String station_from;
    private String station_to;

    public RailcarOperation(Long railcar_num, String operation_type, String operation_status) {
        this.railcar_num = railcar_num;
        this.operation_type = operation_type;
        this.operation_status = operation_status;
    }
}
