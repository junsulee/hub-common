package com.blackducksoftware.integration.hub.report.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Test;

public class UserDataTest {

    @Test
    public void testUserData() {
        final String id1 = "Id1";
        final String username1 = "username1";

        final String id2 = UUID.randomUUID().toString();
        final String username2 = "username2";

        UserData item1 = new UserData(id1, username1);
        UserData item2 = new UserData(id2, username2);
        UserData item3 = new UserData(id1, username1);
        UserData item4 = new UserData(null, null);

        assertEquals(id1, item1.getId());
        assertEquals(username1, item1.getUsername());

        assertEquals(id2, item2.getId());
        assertEquals(username2, item2.getUsername());

        assertTrue(!item1.equals(item2));
        assertTrue(item1.equals(item3));

        EqualsVerifier.forClass(UserData.class).suppress(Warning.STRICT_INHERITANCE).verify();

        assertTrue(item1.hashCode() != item2.hashCode());
        assertEquals(item1.hashCode(), item3.hashCode());

        assertNull(item1.getUUId());
        assertNull(item4.getUUId());
        assertEquals(id2, item2.getUUId().toString());

        StringBuilder builder = new StringBuilder();
        builder.append("UserData [id=");
        builder.append(item1.getId());
        builder.append(", username=");
        builder.append(item1.getUsername());
        builder.append("]");

        assertEquals(builder.toString(), item1.toString());
    }

}