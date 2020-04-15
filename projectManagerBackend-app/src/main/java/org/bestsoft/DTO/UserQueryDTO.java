package org.bestsoft.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserQueryDTO {
    private String key;
    private String value;
}
