package xyz.luan.models.trinket;

import io.yawp.commons.http.annotation.PUT;
import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

public class TrinketTableMakerAction extends Action<Trinket> {

    private static class Data {
        String table;
    }

    @PUT("table-maker")
    public String tableMaker(Data data) {
        // TableMaker.convertBody(
        return "result: " +  data.table;
    }

}
