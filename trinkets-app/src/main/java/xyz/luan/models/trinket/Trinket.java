package xyz.luan.models.trinket;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;

@Endpoint(path = "/trinkets")
public class Trinket {

    @Id
    IdRef<Trinket> id;

}
