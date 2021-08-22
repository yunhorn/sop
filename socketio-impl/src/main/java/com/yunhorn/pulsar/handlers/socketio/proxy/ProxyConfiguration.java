/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yunhorn.pulsar.handlers.socketio.proxy;

import com.google.common.collect.ImmutableList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.apache.pulsar.common.configuration.Category;
import org.apache.pulsar.common.configuration.FieldContext;

/**
 * Configuration for SocketIO proxy service.
 */
@Getter
@Setter
public class ProxyConfiguration {

    @Category
    private static final String CATEGORY_SOCKETIO = "SocketIO on Pulsar";
    @Category
    private static final String CATEGORY_SOCKETIO_PROXY = "SocketIO Proxy";
    @Category
    private static final String CATEGORY_BROKER_DISCOVERY = "Broker Discovery";
    @Category(
        description = "the settings are for configuring how proxies authenticates with Pulsar brokers"
    )
    private static final String CATEGORY_CLIENT_AUTHENTICATION = "Broker Client Authorization";

    @FieldContext(
            category = CATEGORY_SOCKETIO,
            required = true,
            doc = "SocketIO on Pulsar Broker tenant"
    )
    private String socketIOTenant = "public";

    @FieldContext(
        category = CATEGORY_SOCKETIO,
        doc = "A comma-separated list of authentication methods to enable."
    )
    private List<String> mqttAuthenticationMethods = ImmutableList.of();

    @FieldContext(
            category = CATEGORY_SOCKETIO_PROXY,
            required = false,
            doc = "The socketIO proxy port"
    )
    private int socketIOProxyPort = 5682;

    @FieldContext(
            category = CATEGORY_BROKER_DISCOVERY,
            doc = "The service url points to the broker cluster"
    )
    private String brokerServiceURL;

    @FieldContext(
        category = CATEGORY_CLIENT_AUTHENTICATION,
        doc = "The authentication plugin used by the Pulsar proxy to authenticate with Pulsar brokers"
    )
    private String brokerClientAuthenticationPlugin;

    @FieldContext(
        category = CATEGORY_CLIENT_AUTHENTICATION,
        doc = "The authentication parameters used by the Pulsar proxy to authenticate with Pulsar brokers"
    )
    private String brokerClientAuthenticationParameters;

    @FieldContext(
            category = CATEGORY_SOCKETIO,
            required = true,
            doc = "Default Pulsar tenant that the SocketIO server used."
    )
    private String defaultTenant = "public";

    @FieldContext(
            category = CATEGORY_SOCKETIO,
            required = true,
            doc = "Default Pulsar namespace that the SocketIO server used."
    )
    private String defaultNamespace = "default";
}
