import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	protected String contactID, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
	protected String longContactID, longFirstNameTest, longLastNameTest, longPhoneNumberTest, longAddressTest, shortPhoneNumber;

	
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
		shortPhoneNumber = "1234567";
		longAddressTest ="Knothole Island North Of Albion by the Spire";
	}
	
	@Test
	void newContactID() {
		ContactService service = new ContactService();
		service.newContact();
		assertAll("service",
				() -> assertNotNull(service.getContactList().get(0).getContactID()),
				() -> assertEquals("DEFAULT", service.getContactList().get(0).getFirstName()),
				() -> assertEquals("DEFAULT", service.getContactList().get(0).getLastName()),
				() -> assertEquals("1234567899", service.getContactList().get(0).getPhoneNumber()),
				() -> assertEquals("DEFAULT", service.getContactList().get(0).getAddress())
				);
		
		service.newContact(firstNameTest);
		assertAll("service",
				() -> assertNotNull(service.getContactList().get(1).getContactID()),
				() -> assertEquals(firstNameTest, service.getContactList().get(1).getFirstName()),
				() -> assertEquals("DEFAULT", service.getContactList().get(1).getLastName()),
				() -> assertEquals("1234567899", service.getContactList().get(1).getPhoneNumber()),
				() -> assertEquals("DEFAULT", service.getContactList().get(1).getAddress())
				);
		
		service.newContact(firstNameTest, lastNameTest);
		assertAll("service",
				() -> assertNotNull(service.getContactList().get(2).getContactID()),
				() -> assertEquals(firstNameTest, service.getContactList().get(2).getFirstName()),
				() -> assertEquals(lastNameTest, service.getContactList().get(2).getLastName()),
				() -> assertEquals("1234567899", service.getContactList().get(2).getPhoneNumber()),
				() -> assertEquals("DEFAULT", service.getContactList().get(2).getAddress())
				);
		
		service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
		assertAll(
				() -> assertNotNull(service.getContactList().get(3).getContactID()),
				() -> assertEquals(firstNameTest, service.getContactList().get(3).getFirstName()),
				() -> assertEquals(lastNameTest, service.getContactList().get(3).getLastName()),
				() -> assertEquals(phoneNumberTest, service.getContactList().get(3).getPhoneNumber()),
				() -> assertEquals("DEFAULT", service.getContactList().get(3).getAddress())
				);
		
		service.newContact(firstNameTest, lastNameTest, phoneNumberTest, addressTest);
		assertAll(
				() -> assertNotNull(service.getContactList().get(4).getContactID()),
				() -> assertEquals(firstNameTest, service.getContactList().get(4).getFirstName()),
				() -> assertEquals(lastNameTest, service.getContactList().get(4).getLastName()),
				() -> assertEquals(phoneNumberTest, service.getContactList().get(4).getPhoneNumber()),
				() -> assertEquals(addressTest, service.getContactList().get(4).getAddress())
				);
	}
		
	@Test
	void updateFirstNameTest() throws Exception  {
		ContactService service = new ContactService();
		service.newContact();
		service.updateFirstName(service.getContactList().get(0).getContactID(), firstNameTest);
		assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
		assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(service.getContactList().get(0).getContactID(),longFirstNameTest));
		assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(service.getContactList().get(0).getContactID(), null));
		assertThrows(Exception.class, () -> service.updateFirstName(contactID, firstNameTest));
	}
	
	@Test
	void updateLastNameTest() throws Exception  {
		ContactService service = new ContactService();
		service.newContact();
		service.updateLastName(service.getContactList().get(0).getContactID(), lastNameTest);
		assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
		assertThrows(IllegalArgumentException.class, () -> service.updateLastName(service.getContactList().get(0).getContactID(),longLastNameTest));
		assertThrows(IllegalArgumentException.class, () -> service.updateLastName(service.getContactList().get(0).getContactID(), null));
		assertThrows(Exception.class, () -> service.updateLastName(contactID, lastNameTest));
	}
	
	@Test
	  void updatePhoneNumberTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.updatePhoneNumber(service.getContactList().get(0).getContactID(),phoneNumberTest);
	    assertEquals(phoneNumberTest,service.getContactList().get(0).getPhoneNumber());
	    assertThrows(IllegalArgumentException.class,() -> service.updatePhoneNumber(service.getContactList().get(0).getContactID(),longPhoneNumberTest));
	    assertThrows(IllegalArgumentException.class,() -> service.updatePhoneNumber(service.getContactList().get(0).getContactID(), shortPhoneNumber));
	    assertThrows(IllegalArgumentException.class,() -> service.updatePhoneNumber(service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class, () -> service.updatePhoneNumber(contactID, phoneNumberTest));
	  }
	@Test
	void updateAddressTest() throws Exception{
		ContactService service = new ContactService();
		service.newContact();
		service.updateAdress(service.getContactList().get(0).getContactID(), addressTest);
		assertEquals(addressTest, service.getContactList().get(0).getAddress());
		assertThrows(IllegalArgumentException.class,() -> service.updateAdress(service.getContactList().get(0).getContactID(), longAddressTest));
		assertThrows(IllegalArgumentException.class,() -> service.updateAdress(service.getContactList().get(0).getContactID(), null));
		assertThrows(Exception.class, () -> service.updateAdress(contactID, addressTest));
	}
	
	@Test
	void deleteContactTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertThrows(Exception.class, () -> service.deleteContact(contactID));
		assertAll(()-> service.deleteContact(service.getContactList().get(0).getContactID()));
	}
}
