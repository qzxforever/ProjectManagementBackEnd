package org.bestsoft.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ServiceJobDTO {
    private String executeUser;
    private String confirmUser;
    private String cdate;
    private String edate;
    private String remark;
}
