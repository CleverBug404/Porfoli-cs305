import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ContactTest {
	protected String contactID, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
	protected String longContactID, longFirstNameTest, longLastNameTest, longPhoneNumberTest, longAddressTest;
	
	@BeforeEach
	void setUp() {
		contactID ="ABCDE12345";
		firstNameTest ="Jack";
		lastNameTest ="Blades";
		phoneNumberTest ="7867736495";
		addressTest ="Heros Guild";
		longContactID = "12345678900";
		longFirstNameTest ="TheresaRosalia";
		longLastNameTest ="TheNightOfSpades";
		longPhoneNumberTest ="77733389651";
		longAddressTest ="Knothole Island North Of Albion by the Spire";
	}
	@Test
	void contactTest() {
		Contact contact = new Contact();
		assertAll("Constructor", 
				() -> assertNotNull(contact.getContactID()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress())
				);
	}
	
	@Test
	void contactIDConstructorTest() {
		Contact contact = new Contact(contactID);
		assertAll("Constructor ID",
				() -> assertEquals(contactID, contact.getContactID()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress())				
				);
	}
	@Test
	void contactIDandFirstNameConstructorTest() {
		Contact contact = new Contact(contactID, firstNameTest);
		assertAll("Constructor ID, FN",
				() -> assertEquals(contactID, contact.getContactID()),
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress())				
				);
	}
	
	@Test
	void contactIDandFirstNameandLastNameConstructorTest(){
		Contact contact = new Contact(contactID, firstNameTest, lastNameTest);
		assertAll("Constructor ID, FN, LN",
				() -> assertEquals(contactID, contact.getContactID()),
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertEquals(lastNameTest ,contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress())
				);
	}
	@Test
	void contactIDandFirstNameandLastNameandPhoneNumberConstructorTest() {
		Contact contact = new Contact(contactID, firstNameTest, lastNameTest, phoneNumberTest);
		assertAll("Constructor ID, FN, LS, PN",
				() -> assertEquals(contactID, contact.getContactID()),
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertEquals(lastNameTest ,contact.getLastName()),
				() -> assertNotNull(phoneNumberTest, contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress())
				);
	}
	@Test
	void contactIDandFirstNameandLastNameandPhoneNumberandAddressConstructorTest() {
		Contact contact = new Contact(contactID, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
		assertAll("Constructor ID, FN, LS, PN",
				() -> assertEquals(contactID, contact.getContactID()),
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertEquals(lastNameTest ,contact.getLastName()),
				() -> assertNotNull(phoneNumberTest, contact.getPhoneNumber()),
				() -> assertNotNull(addressTest ,contact.getAddress())
				);
	}
	@Test
	void updateContactID() {
		Contact contact = new Contact();
		contact.updateContactID(contactID);
		assertAll("update contactID",
				() -> assertEquals(contactID, contact.getContactID()),
	            () -> assertThrows(IllegalArgumentException.class, () -> contact.updateContactID(null)),
	            () -> assertThrows(IllegalArgumentException.class, () -> contact.updateContactID(longContactID)));
	}
	@Test
	void updateContactFirstName() {
		Contact contact = new Contact();
		contact.updateFirstName(firstNameTest);
		assertAll("update contactFirstName",
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(longFirstNameTest))
				);
	}
	@Test
	void updateContactLastName() {
		Contact contact = new Contact();
		contact.updateLastName(lastNameTest);
		assertAll("update contactLastName",
				() -> assertEquals(lastNameTest, contact.getLastName()),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(longLastNameTest))
				);
	}
	@Test
	void updateContactPhoneNumber() {
		Contact contact = new Contact();
		contact.updatePhoneNumber(phoneNumberTest);
		assertAll("update contactPhoneNumber",
				() -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(longPhoneNumberTest))
				);
	}
	@Test
	void updateContactAddress() {
		Contact contact = new Contact();
		contact.updateAddress(addressTest);
		assertAll("update address",
				() -> assertEquals(addressTest, contact.getAddress()),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(longAddressTest))
				);
	}
}