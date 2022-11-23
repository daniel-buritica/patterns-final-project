package co.com.umb.patrones.forum.webapp.domain.model;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {


    private int id;
    private String name;
    private String lastname;
    private int cardId;
    private String dateBirth;
    private String profession;
    private String email;
    private String countries;
    private String city;
}
