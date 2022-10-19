package com.api.Api.Rest.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="foto_producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class FotoProducto extends Base {



}
