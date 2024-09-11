package org.example.capadeacceso_desafiodia11.service.serviceimpl;

import org.example.capadeacceso_desafiodia11.dao.ProviderDAO;
import org.example.capadeacceso_desafiodia11.dao.daoimpl.ProviderDAOimpl;
import org.example.capadeacceso_desafiodia11.model.ProviderDTO;
import org.example.capadeacceso_desafiodia11.service.ProviderService;

import java.util.List;

public class ProviderServiceImpl implements ProviderService {

    private final ProviderDAO objProviderDao;

    public ProviderServiceImpl(){
        this.objProviderDao = new ProviderDAOimpl(){
        };
    }

    @Override
    public ProviderDTO selectProvider(int id) {
        return objProviderDao.selectProvider(id);
    }

    @Override
    public List<ProviderDTO> selectAllProviders() {
        return objProviderDao.selectAllProviders();
    }

    @Override
    public ProviderDTO insertProvider(ProviderDTO provider) {
        return objProviderDao.insertProvider(provider);
    }

    @Override
    public ProviderDTO updateProvider(ProviderDTO provider) {
        return objProviderDao.updateProvider(provider);
    }

    @Override
    public boolean deleteProvider(int id) {
        return objProviderDao.deleteProvider(id);
    }

}
