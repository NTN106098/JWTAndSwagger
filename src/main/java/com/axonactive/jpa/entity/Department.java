package com.axonactive.jpa.entity;

import com.axonactive.jpa.persistence.IEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@Table(name = "department")
public class Department implements IEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private Integer id;

    @Column(nullable = false, columnDefinition = "varchar(200)")
    private String name;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "start_date")
    private LocalDate startDate;

}
