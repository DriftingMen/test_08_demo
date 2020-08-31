package com.drift.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-drift-entity-Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private String name;

    @ApiModelProperty(value="")
    private String birthday;

    @ApiModelProperty(value="")
    private Integer depId;
}