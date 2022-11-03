package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
    
    private final RecoveryRoomService recoveryRoomService;
    private static final String VIEWS_RECORVERY_ROOM_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";

    @Autowired
    public RecoveryRoomController(RecoveryRoomService recoveryRoomService){
        this.recoveryRoomService = recoveryRoomService;
    }

    @GetMapping(value="/create")
    public String initCreationForm(ModelMap model){
        RecoveryRoom recoveryRoom = new RecoveryRoom();
        List<RecoveryRoomType> types = this.recoveryRoomService.getAllRecoveryRoomTypes();
        model.put("recoveryRoom", recoveryRoom);
        model.put("types", types);
        return VIEWS_RECORVERY_ROOM_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping(value="/create")
    public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.put("recoveryRoom", recoveryRoom);
            return VIEWS_RECORVERY_ROOM_CREATE_OR_UPDATE_FORM;
        }else{
            try{
                this.recoveryRoomService.save(recoveryRoom);
                return("welcome");
            }catch(DuplicatedRoomNameException ex){
                result.rejectValue("name", "duplicate", "already exists");
                return VIEWS_RECORVERY_ROOM_CREATE_OR_UPDATE_FORM;
            }
        }
    }


}
