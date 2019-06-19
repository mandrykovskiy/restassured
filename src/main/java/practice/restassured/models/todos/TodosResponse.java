package practice.restassured.models.todos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.restassured.models.users.Address;
import practice.restassured.models.users.Company;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodosResponse {
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("completed")
    private Boolean completed;
}
