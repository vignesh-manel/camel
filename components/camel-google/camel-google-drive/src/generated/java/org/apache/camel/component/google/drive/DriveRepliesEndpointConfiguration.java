/*
 * Camel EndpointConfiguration generated by camel-api-component-maven-plugin
 */
package org.apache.camel.component.google.drive;

import org.apache.camel.spi.ApiMethod;
import org.apache.camel.spi.ApiParam;
import org.apache.camel.spi.ApiParams;
import org.apache.camel.spi.Configurer;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

/**
 * Camel endpoint configuration for {@link com.google.api.services.drive.Drive.Replies}.
 */
@ApiParams(apiName = "drive-replies", 
           description = "The replies collection of methods",
           apiMethods = {@ApiMethod(methodName = "create", description="Creates a reply to a comment", signatures={"com.google.api.services.drive.Drive$Replies$Create create(String fileId, String commentId, com.google.api.services.drive.model.Reply content)"}), @ApiMethod(methodName = "delete", description="Deletes a reply", signatures={"com.google.api.services.drive.Drive$Replies$Delete delete(String fileId, String commentId, String replyId)"}), @ApiMethod(methodName = "get", description="Gets a reply by ID", signatures={"com.google.api.services.drive.Drive$Replies$Get get(String fileId, String commentId, String replyId)"}), @ApiMethod(methodName = "list", description="Lists a comment's replies", signatures={"com.google.api.services.drive.Drive$Replies$List list(String fileId, String commentId)"}), @ApiMethod(methodName = "update", description="Updates a reply with patch semantics", signatures={"com.google.api.services.drive.Drive$Replies$Update update(String fileId, String commentId, String replyId, com.google.api.services.drive.model.Reply content)"})}, aliases = {})
@UriParams
@Configurer(extended = true)
public final class DriveRepliesEndpointConfiguration extends GoogleDriveConfiguration {
    @UriParam
    @ApiParam(optional = false, apiMethods = {@ApiMethod(methodName = "create", description="The ID of the comment"), @ApiMethod(methodName = "delete", description="The ID of the comment"), @ApiMethod(methodName = "get", description="The ID of the comment"), @ApiMethod(methodName = "list", description="The ID of the comment"), @ApiMethod(methodName = "update", description="The ID of the comment")})
    private String commentId;
    @UriParam
    @ApiParam(optional = false, apiMethods = {@ApiMethod(methodName = "create", description="The com.google.api.services.drive.model.Reply"), @ApiMethod(methodName = "update", description="The com.google.api.services.drive.model.Reply")})
    private com.google.api.services.drive.model.Reply content;
    @UriParam
    @ApiParam(optional = false, apiMethods = {@ApiMethod(methodName = "create", description="The ID of the file"), @ApiMethod(methodName = "delete", description="The ID of the file"), @ApiMethod(methodName = "get", description="The ID of the file"), @ApiMethod(methodName = "list", description="The ID of the file"), @ApiMethod(methodName = "update", description="The ID of the file")})
    private String fileId;
    @UriParam
    @ApiParam(optional = false, apiMethods = {@ApiMethod(methodName = "delete", description="The ID of the reply"), @ApiMethod(methodName = "get", description="The ID of the reply"), @ApiMethod(methodName = "update", description="The ID of the reply")})
    private String replyId;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public com.google.api.services.drive.model.Reply getContent() {
        return content;
    }

    public void setContent(com.google.api.services.drive.model.Reply content) {
        this.content = content;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }
}
