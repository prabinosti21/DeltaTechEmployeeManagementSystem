package com.deltatech.Deltatech_EMS.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeltaTech{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "e_id_generator")
    @SequenceGenerator(name = "e_id_generator", sequenceName = "employee_sequence")
    private Long eid;

    @NotBlank(message = "Please provide first name.")
    private String firstName;

    @NotBlank(message = "Please provide last name.")
    private String lastName;

    @Email(message = "Please provide valid email address.")
    @NotBlank(message = "Please provide email address.")
    private String email;

    @NotBlank(message = "Please provide gender")
    private String gender;
    private Long phoneNumber;
    private Double annualSalary;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="eId", referencedColumnName = "eid")
    private List<Address> addressList;
}
