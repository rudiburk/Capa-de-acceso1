package org.example.capadeacceso_desafiodia11.service;

import org.example.capadeacceso_desafiodia11.model.ProviderDTO;

import java.util.List;

public interface ProviderService {
    public ProviderDTO selectProvider(int id);

    public List<ProviderDTO> selectAllProviders();

    public ProviderDTO insertProvider(ProviderDTO provider);

    public ProviderDTO updateProvider(ProviderDTO provider);

    public boolean deleteProvider(int id);
}
