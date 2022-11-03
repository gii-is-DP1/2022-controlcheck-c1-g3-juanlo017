package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="recovery_rooms")
public class RecoveryRoom {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @NotBlank
    @Size(min=3, max=50)
    String name;
    
    @PositiveOrZero
    double size;

    @NotNull
    boolean secure;

    @ManyToOne
    @JoinColumn(name = "room_type")
    RecoveryRoomType roomType;
}
