package practice.restassured.models.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Geo {
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lng")
    private String lng;
}
