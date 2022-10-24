package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.userpostgresql.helper;

public interface MapperGeneric <E, M>{
    E toEntity(M model);
    M toModel(E entity);

}
