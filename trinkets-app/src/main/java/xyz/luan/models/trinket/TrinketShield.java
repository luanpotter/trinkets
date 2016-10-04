package xyz.luan.models.trinket;

import io.yawp.repository.shields.Shield;
import io.yawp.commons.http.annotation.PUT;

public class TrinketShield extends Shield<Trinket> {

    @Override
    public void defaults() {
        allow(false);
    }

    @PUT("table-maker")
    public void table() {
        allow();
    }

}
