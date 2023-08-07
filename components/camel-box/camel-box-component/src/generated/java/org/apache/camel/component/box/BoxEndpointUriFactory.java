/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.box;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.camel.spi.EndpointUriFactory;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
public class BoxEndpointUriFactory extends org.apache.camel.support.component.EndpointUriFactorySupport implements EndpointUriFactory {

    private static final String BASE = ":apiName/methodName";

    private static final Set<String> PROPERTY_NAMES;
    private static final Set<String> SECRET_PROPERTY_NAMES;
    private static final Set<String> MULTI_VALUE_PREFIXES;
    static {
        Set<String> props = new HashSet<>(85);
        props.add("access");
        props.add("accessTokenCache");
        props.add("action");
        props.add("after");
        props.add("apiName");
        props.add("assignTo");
        props.add("authenticationType");
        props.add("before");
        props.add("check");
        props.add("clientId");
        props.add("clientSecret");
        props.add("collaborationId");
        props.add("collaborator");
        props.add("commentId");
        props.add("content");
        props.add("created");
        props.add("description");
        props.add("destinationFolderId");
        props.add("dueAt");
        props.add("email");
        props.add("emailAliasId");
        props.add("encryptionAlgorithm");
        props.add("enterpriseId");
        props.add("exceptionHandler");
        props.add("exchangePattern");
        props.add("externalSyncIdentifier");
        props.add("fields");
        props.add("fileContent");
        props.add("fileId");
        props.add("fileName");
        props.add("fileSize");
        props.add("filterTerm");
        props.add("folderId");
        props.add("folderName");
        props.add("force");
        props.add("groupId");
        props.add("groupInfo");
        props.add("groupMembershipId");
        props.add("httpParams");
        props.add("inBody");
        props.add("info");
        props.add("invitabilityLevel");
        props.add("lazyStartProducer");
        props.add("limit");
        props.add("listener");
        props.add("login");
        props.add("maxCacheEntries");
        props.add("memberViewabilityLevel");
        props.add("message");
        props.add("metadata");
        props.add("methodName");
        props.add("modified");
        props.add("name");
        props.add("newFileName");
        props.add("newFolderName");
        props.add("newName");
        props.add("notifyUser");
        props.add("offset");
        props.add("output");
        props.add("params");
        props.add("parentFolderId");
        props.add("path");
        props.add("permissions");
        props.add("position");
        props.add("privateKeyFile");
        props.add("privateKeyPassword");
        props.add("provenance");
        props.add("publicKeyId");
        props.add("query");
        props.add("rangeEnd");
        props.add("rangeStart");
        props.add("role");
        props.add("size");
        props.add("sourceUserId");
        props.add("sslContextParameters");
        props.add("startingPosition");
        props.add("taskAssignmentId");
        props.add("taskId");
        props.add("typeName");
        props.add("types");
        props.add("unshareDate");
        props.add("userId");
        props.add("userName");
        props.add("userPassword");
        props.add("version");
        PROPERTY_NAMES = Collections.unmodifiableSet(props);
        Set<String> secretProps = new HashSet<>(6);
        secretProps.add("clientSecret");
        secretProps.add("privateKeyFile");
        secretProps.add("privateKeyPassword");
        secretProps.add("publicKeyId");
        secretProps.add("userName");
        secretProps.add("userPassword");
        SECRET_PROPERTY_NAMES = Collections.unmodifiableSet(secretProps);
        MULTI_VALUE_PREFIXES = Collections.emptySet();
    }

    @Override
    public boolean isEnabled(String scheme) {
        return "box".equals(scheme);
    }

    @Override
    public String buildUri(String scheme, Map<String, Object> properties, boolean encode) throws URISyntaxException {
        String syntax = scheme + BASE;
        String uri = syntax;

        Map<String, Object> copy = new HashMap<>(properties);

        uri = buildPathParameter(syntax, uri, "apiName", null, true, copy);
        uri = buildPathParameter(syntax, uri, "methodName", null, true, copy);
        uri = buildQueryParameters(uri, copy, encode);
        return uri;
    }

    @Override
    public Set<String> propertyNames() {
        return PROPERTY_NAMES;
    }

    @Override
    public Set<String> secretPropertyNames() {
        return SECRET_PROPERTY_NAMES;
    }

    @Override
    public Set<String> multiValuePrefixes() {
        return MULTI_VALUE_PREFIXES;
    }

    @Override
    public boolean isLenientProperties() {
        return true;
    }
}

