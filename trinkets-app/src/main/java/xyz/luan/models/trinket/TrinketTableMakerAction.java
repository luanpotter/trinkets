package xyz.luan.models.trinket;

import io.yawp.commons.http.annotation.GET;
import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

public class TrinketTableMakerAction extends Action<Trinket> {

    @GET("table-maker")
    public String tableMaker(String table) {
        // TableMaker.convertBody(
        return "result: " +  table;
    }

}
