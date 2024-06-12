/**
 *
 * @author Furkan AK @Kowachka
 */

package music_program_application;

public class MembershipType extends User {

	private String membership_type;

	public MembershipType(String membership_type) {
		this.membership_type = membership_type;

	}

	public MembershipType() {

	}

	public String getMembershipt_type() {
		return membership_type;
	}

	public void setMembership_type(String membership_type) {
		this.membership_type = membership_type;
	}

}
