package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="recovery_room_types")
public class RecoveryRoomType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    @NotBlank
    @Size(min=5, max=50)
    String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomType")
	private List<RecoveryRoom> rooms;
}
