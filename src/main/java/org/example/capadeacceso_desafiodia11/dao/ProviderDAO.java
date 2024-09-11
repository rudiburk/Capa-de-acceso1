package org.example.capadeacceso_desafiodia11.dao;

import org.example.capadeacceso_desafiodia11.model.ProviderDTO;

import java.util.List;

public interface ProviderDAO {
    //CRUD//

    public ProviderDTO selectProvider(int id);

    public List<ProviderDTO> selectAllProviders();

    public ProviderDTO insertProvider(ProviderDTO providerDTO);

    public ProviderDTO updateProvider(ProviderDTO providerDTO);

    public boolean deleteProvider(int id);


}
