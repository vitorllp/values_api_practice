package api.project.valuesapi.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValueDTO {
    @Id
    private Long id;

    @NotEmpty
    @Size(min = 1,max = 100)
    private String valueName;

    @NotEmpty
    @Size(min = 1,max = 100)
    private String valueContent;

}
