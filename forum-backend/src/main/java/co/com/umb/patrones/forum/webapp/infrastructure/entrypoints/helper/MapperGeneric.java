package co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.helper;

public interface MapperGeneric <E, D>{
    E toModel(D dto);
    D toDTO(E entity);
}
