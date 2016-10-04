package xyz.luan.models.trinket;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import xyz.luan.utils.EndpointTestCase;

public class TrinketTest extends EndpointTestCase {

    @Test
    public void testTableMaker() {
        String json = put("/trinkets/table-maker", "{ table : 'table'}");
        assertEquals("\"result: table\"", json);
    }

}
