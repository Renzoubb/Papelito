package com.api.Api.Rest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="rol")
@Data@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Rol {
    @Id
    @GeneratedValue(strategy =AUTO)
    private Long id;
    private String name;
}
