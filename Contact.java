
public class Contact {
	//Variable declaration
	private String contactID, firstName, lastName, phoneNumber, address;
	
	//values requirement
	private static final byte contactIdSize = 10;
	private static final byte firstNameSize = 10;
	private static final byte lastNameSize = 10;
	private static final int phoneNumberSize = 10;
	private static final byte addressSize = 30;
	
	//variable initialization
	private static final String DefaultValue = "DEFAULT";
	private static final String DefaulPhoneValue = "1234567899";
	
	
	Contact(){
		this.contactID = DefaultValue;
		this.firstName = DefaultValue;
		this.lastName = DefaultValue;
		this.phoneNumber = DefaulPhoneValue;
		this.address = DefaultValue;
	}
	
	//get methods
	protected final String getContactID() { return contactID; }
	protected final String getFirstName() { return firstName; }
	protected final String getLastName() { return lastName; }
	protected final String getPhoneNumber() { return phoneNumber; }
	protected final String getAddress() { return address; }
	
	//update methods
	protected void updateContactID(String contactID) {
		if (contactID == null) {
			throw new IllegalArgumentException("The Contact ID cannot be empty");
		} else if ( contactID.length() > contactIdSize) {
			throw new IllegalArgumentException("The contact ID cannot be longer than " + contactIdSize + " characters");
		} else {
			this.contactID = contactID;
		}
	}
	protected void updateFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("The first name cannot be empty");
		} else if (firstName.length() > firstNameSize) {
			throw new IllegalArgumentException("The first name cannot be more than " + firstNameSize + " characters");
		} else {
			this.firstName = firstName;
		}
	}
	protected void updateLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("The last name cannot be empty");
		} else if (lastName.length() > lastNameSize) {
			throw new IllegalArgumentException("The last name cannot be more than " + lastNameSize + " characters");
		} else {
			this.lastName = lastName;
		}
		
	} 
	protected void updatePhoneNumber(String phoneNumber) {
		if (phoneNumber == null) {
			throw new IllegalArgumentException("The number cannot be empty");
		} else if (phoneNumber.length() != phoneNumberSize) {
			throw new IllegalArgumentException("The phone number has to be exactly " +phoneNumberSize+" characters");
		} else {
			this.phoneNumber = phoneNumber;
		}
	}
	protected void updateAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("The address field needs to be populated");
		} else if (address.length() > addressSize) {
			throw new IllegalArgumentException("The address cannot be more than " + addressSize + " characters");
		} else {
			this.address = address;
		}
	}
	
	Contact(String contactID){
		updateContactID(contactID);
		this.firstName = DefaultValue;
		this.lastName = DefaultValue;
		this.phoneNumber = DefaulPhoneValue;
		this.address = DefaultValue;
	}
	Contact(String contactID, String firstName){
		updateContactID(contactID);
		updateFirstName(firstName);
		this.lastName = DefaultValue;
		this.phoneNumber = DefaulPhoneValue;
		this.address = DefaultValue;
	}
	Contact(String contactID, String firstName, String lastName){
		updateContactID(contactID);
		updateFirstName(firstName);
		updateLastName(lastName);
		this.phoneNumber = DefaulPhoneValue;
		this.address = DefaultValue;
	}
	Contact(String contactID, String firstName, String lastName, String phoneNumber){
		updateContactID(contactID);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		this.address = DefaultValue;
	}
	Contact(String contactID, String firstName, String lastName, String phoneNumber, String address){
		updateContactID(contactID);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		updateAddress(address);
	}
}