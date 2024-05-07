package com.skillstorm.taxprepapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.skillstorm.taxprepapp.models.Admin;

public class AdminTests {

    @Test
    public void testGetSetOauthId() {
        Admin admin = new Admin();
        admin.setOauthId("testOauthId");
        assertEquals("testOauthId", admin.getOauthId());
    }

    @Test
    public void testEqualsAndHashCode() {
        Admin admin1 = new Admin("oauthId1");
        Admin admin2 = new Admin("oauthId1");
        Admin admin3 = new Admin("oauthId2");

        assertTrue(admin1.equals(admin2));
        assertFalse(admin1.equals(admin3));

        assertEquals(admin1.hashCode(), admin2.hashCode());
        assertNotEquals(admin1.hashCode(), admin3.hashCode());
    }

    @Test
    public void testToString() {
        Admin admin = new Admin("testOauthId");
        assertEquals("Admin [oauthId=testOauthId]", admin.toString());
    }
}
