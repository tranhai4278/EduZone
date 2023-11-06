package model;

import java.util.Date;

public class Comment {
    private int commentId;
    private String comment;
    private int userId;
    private int discussionId;
    private int replyId;
    private Date createAt;
    private int createBy;
    private Date updateAt;
    private int updateBy;
    
    private String fullName;

    public Comment() {
    }

    public Comment(int commentId, String comment, int userId, int discussionId, int replyId, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.commentId = commentId;
        this.comment = comment;
        this.userId = userId;
        this.discussionId = discussionId;
        this.replyId = replyId;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }
    
    public Comment(int commentId, String comment, String fullName, int discussionId, int replyId, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.commentId = commentId;
        this.comment = comment;
        this.fullName = fullName;
        this.discussionId = discussionId;
        this.replyId = replyId;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(int discussionId) {
        this.discussionId = discussionId;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    
}
