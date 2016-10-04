package xyz.luan.models.trinket;

import xyz.luan.trinkets.TableMaker;

import io.yawp.commons.http.annotation.PUT;
import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

public class TrinketTableMakerAction extends Action<Trinket> {

    private static class Data {
        String table;
    }

    @PUT("table-maker")
    public Data tableMaker(Data data) {
	data.table = TableMaker.convertBody(data.table);
        return data;
    }

}
