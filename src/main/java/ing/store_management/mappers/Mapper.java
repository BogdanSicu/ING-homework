package ing.store_management.mappers;

public interface Mapper <M,D> {

    public D toDTO(M model);
    public M toModel(D dto);

}
