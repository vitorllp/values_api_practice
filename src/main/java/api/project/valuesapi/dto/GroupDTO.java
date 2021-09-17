package api.project.valuesapi.dto;

import api.project.valuesapi.entity.Value;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupDTO {
    @NotEmpty
    @Id
    private Long id;

    @NotEmpty
    @Size(min = 3,max = 15)
    private String code;

    @NotEmpty
    @Size(min = 1,max = 100)
    private String groupName;

    @NotEmpty
    private final LocalDate creationDate = LocalDate.now();

    @NotEmpty
    @Valid
    private List<Value> values;
}
