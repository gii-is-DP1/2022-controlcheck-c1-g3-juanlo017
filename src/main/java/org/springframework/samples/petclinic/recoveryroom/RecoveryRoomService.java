package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {

    private final RecoveryRoomRepository repository;

    @Autowired
    public RecoveryRoomService(RecoveryRoomRepository repository){
        this.repository = repository;
    }
    
    public List<RecoveryRoom> getAll(){
        return this.repository.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return this.repository.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return this.repository.getRecoveryRoomType(typeName);
    }

    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
        return this.repository.save(p);       
    }

    
}
