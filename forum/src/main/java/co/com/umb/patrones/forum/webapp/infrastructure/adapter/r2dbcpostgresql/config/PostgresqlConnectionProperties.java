package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.config;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostgresqlConnectionProperties {
    private String database;
    private String schema;
    private String username;
    private String password;
    private String host;
    private Integer port;
}
