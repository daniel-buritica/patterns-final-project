package co.com.umb.patrones.forum.webapp.domain.model;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {


    private int id;
    private int cardId;
    private String name;
    private String lastname;
    private String email;
    private String dateBirth;
    private String countries;
    private String city;
    private String profesion;


}
