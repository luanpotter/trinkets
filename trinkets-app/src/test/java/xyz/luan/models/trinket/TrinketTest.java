package xyz.luan.models.trinket;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import xyz.luan.utils.EndpointTestCase;

public class TrinketTest extends EndpointTestCase {

    @Test
    public void testCreate() {
        // TODO Auto-generated method stub
        String json = post("/trinkets", "{}");
        Trinket trinket = from(json, Trinket.class);

        assertNotNull(trinket);
    }

}
