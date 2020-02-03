package com.openjudge.backend.DTO;

import lombok.Data;

import java.util.List;

/**
 * Created by zy on 2020/1/22
 */

@Data
public class ProblemSetDTO {

    private List<ProblemItemDTO> itemList;
    private Integer total;
    private Integer size;

}
