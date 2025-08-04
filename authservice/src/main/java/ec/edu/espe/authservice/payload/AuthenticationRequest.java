package ec.edu.espe.authservice.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthenticationRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
