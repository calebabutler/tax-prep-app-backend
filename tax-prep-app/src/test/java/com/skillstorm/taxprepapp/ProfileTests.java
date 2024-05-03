package com.skillstorm.taxprepapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.skillstorm.taxprepapp.models.Profile;

@SpringBootTest
public class ProfileTests {

    @Test
    public void testConstructorAndGetters() {
        Profile profile = new Profile(1, "John", "D", "Doe", 19800101, "123 Main St", "Anytown", "CA", 101, 12345,
                123456789, "12345abcde");

        assertEquals(Integer.valueOf(1), profile.getId());
        assertEquals("John", profile.getFirstName());
        assertEquals("D", profile.getMiddleInitial());
        assertEquals("Doe", profile.getLastName());
        assertEquals(Integer.valueOf(19800101), profile.getDateOfBirth());
        assertEquals("123 Main St", profile.getAddress());
        assertEquals("Anytown", profile.getCity());
        assertEquals("CA", profile.getState());
        assertEquals(Integer.valueOf(101), profile.getAptNumber());
        assertEquals(Integer.valueOf(12345), profile.getZipCode());
        assertEquals(Integer.valueOf(123456789), profile.getSsn());
        assertEquals("12345abcde", profile.getOauthId());
    }

    @Test
    public void testEqualsAndHashCode() {
        Profile profile1 = new Profile(1, "John", "D", "Doe", 19800101, "123 Main St", "Anytown", "CA", 101, 12345,
                123456789, "12345abcde");
        Profile profile2 = new Profile(1, "John", "D", "Doe", 19800101, "123 Main St", "Anytown", "CA", 101, 12345,
                123456789, "12345abcde");
        Profile profile3 = new Profile(2, "Jane", "M", "Smith", 19850101, "456 Oak St", "Othertown", "NY", 202, 54321,
                987654321, "67890fghij");

        assertEquals(profile1, profile2);
        assertNotEquals(profile1, profile3);
        assertEquals(profile1.hashCode(), profile2.hashCode());
        assertNotEquals(profile1.hashCode(), profile3.hashCode());
    }

    @Test
    public void testSetters() {
        Profile profile = new Profile();

        profile.setId(1);
        profile.setFirstName("John");
        profile.setMiddleInitial("D");
        profile.setLastName("Doe");
        profile.setDateOfBirth(19800101);
        profile.setAddress("123 Main St");
        profile.setCity("Anytown");
        profile.setState("CA");
        profile.setAptNumber(101);
        profile.setZipCode(12345);
        profile.setSsn(123456789);
        profile.setOauthId("12345abcde");

        assertEquals(Integer.valueOf(1), profile.getId());
        assertEquals("John", profile.getFirstName());
        assertEquals("D", profile.getMiddleInitial());
        assertEquals("Doe", profile.getLastName());
        assertEquals(Integer.valueOf(19800101), profile.getDateOfBirth());
        assertEquals("123 Main St", profile.getAddress());
        assertEquals("Anytown", profile.getCity());
        assertEquals("CA", profile.getState());
        assertEquals(Integer.valueOf(101), profile.getAptNumber());
        assertEquals(Integer.valueOf(12345), profile.getZipCode());
        assertEquals(Integer.valueOf(123456789), profile.getSsn());
        assertEquals("12345abcde", profile.getOauthId());
    }

    @Test
    public void testDefaultConstructorAndSetters() {
        Profile profile = new Profile();

        assertNull(profile.getId());
        assertNull(profile.getFirstName());
        assertNull(profile.getMiddleInitial());
        assertNull(profile.getLastName());
        assertNull(profile.getDateOfBirth());
        assertNull(profile.getAddress());
        assertNull(profile.getCity());
        assertNull(profile.getState());
        assertNull(profile.getAptNumber());
        assertNull(profile.getZipCode());
        assertNull(profile.getSsn());
        assertNull(profile.getOauthId());

        profile.setId(1);
        profile.setFirstName("John");
        profile.setMiddleInitial("D");
        profile.setLastName("Doe");
        profile.setDateOfBirth(19800101);
        profile.setAddress("123 Main St");
        profile.setCity("Anytown");
        profile.setState("CA");
        profile.setAptNumber(101);
        profile.setZipCode(12345);
        profile.setSsn(123456789);
        profile.setOauthId("12345abcde");

        assertEquals(Integer.valueOf(1), profile.getId());
        assertEquals("John", profile.getFirstName());
        assertEquals("D", profile.getMiddleInitial());
        assertEquals("Doe", profile.getLastName());
        assertEquals(Integer.valueOf(19800101), profile.getDateOfBirth());
        assertEquals("123 Main St", profile.getAddress());
        assertEquals("Anytown", profile.getCity());
        assertEquals("CA", profile.getState());
        assertEquals(Integer.valueOf(101), profile.getAptNumber());
        assertEquals(Integer.valueOf(12345), profile.getZipCode());
        assertEquals(Integer.valueOf(123456789), profile.getSsn());
        assertEquals("12345abcde", profile.getOauthId());
    }
}