package com.drift.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-drift-entity-Department")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private String name;
}