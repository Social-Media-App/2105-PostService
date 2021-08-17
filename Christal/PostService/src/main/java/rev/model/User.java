package rev.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	private int userId;

	private String username;

	private String firstName;

	private String middleName;

	private String lastName;

	private byte[] salt;

	private String profilePicture;

	private String backgroundPicture;

	private String email;

}
