package net.lloyddavies.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class DropwizardDemoConfiguration extends Configuration {

    private Boolean swaggerEnabled = true;

    private String swaggerHost = null;

    @JsonProperty
    public Boolean getSwaggerEnabled() {
        return swaggerEnabled;
    }

    @JsonProperty
    public void setSwaggerEnabled(Boolean swaggerEnabled) {
        this.swaggerEnabled = swaggerEnabled;
    }

    @JsonProperty
    public String getSwaggerHost() {
        return swaggerHost;
    }

    @JsonProperty
    public void setSwaggerHost(String swaggerHost) {
        this.swaggerHost = swaggerHost;
    }
}
