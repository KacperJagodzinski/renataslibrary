package org.jagodzinskikacper.renataslibrary.lend;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LendService {

    private final LendRepository lendRepository;

    public LendService(LendRepository lendRepository) {
        this.lendRepository = lendRepository;
    }

    public void create(Lend lend){
        lendRepository.save(lend);
    }

    public void update(Lend lend){
        lendRepository.save(lend);
    }

    public Lend findById(Long id){
        return lendRepository.findById(id).orElse(null);
    }

    public List<Lend> findAll(){
        return lendRepository.findAll();
    }

    public void deleteById(Long id){
        lendRepository.deleteById(id);
    }
}
