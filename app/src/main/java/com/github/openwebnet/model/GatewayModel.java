package com.github.openwebnet.model;

import com.google.common.base.Strings;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

import static com.google.common.base.Preconditions.checkNotNull;

public class GatewayModel extends RealmObject implements RealmModel {

    public static final String FIELD_PASSWORD = "password";

    @Required
    @PrimaryKey
    private String uuid;

    @Required
    private String host;

    @Required
    private Integer port;

    private String password;

    public static GatewayModel newGateway(String host, Integer port, String password) {
        checkNotNull(host, "host is null");
        checkNotNull(port, "port is null");

        GatewayModel gateway = new GatewayModel();
        gateway.setUuid(UUID.randomUUID().toString());
        gateway.setHost(host);
        gateway.setPort(port);
        gateway.setPassword(password);
        return gateway;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordNullable() {
        if (password != null) {
            return Strings.emptyToNull((password.trim().replaceAll("\\s+", "")));
        }
        return null;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
