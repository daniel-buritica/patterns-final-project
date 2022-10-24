package co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonModelDTO {
    private int cardId;
    private String name;
    private String lastname;
    private String email;
    private String dateBirth;
    private String countries;
    private String city;
    private String profesion;
}
