package dal;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Comment;
import model.Discussion;

public class DiscussionDAO extends MySqlConnection {

    public void addDiscussion(int subjectId, int classId, String title, String description, int userId, Timestamp startTime, Timestamp endTime, boolean status) {
        String sql = "INSERT INTO discussion (subject_id, class_id, title, description, user_id, start_time, end_time, status, created_at, create_by, update_at, update_by)\n"
                + "VALUES (" + subjectId + ", \n"
                + "        " + classId + ", \n"
                + "        '" + title + "', \n"
                + "        '" + description + "', \n"
                + "        " + userId + ", \n"
                + "        ?, \n"
                + "        ?, \n"
                + "        " + status + ", \n"
                + "        NOW(), \n"
                + "        " + userId + ", \n"
                + "        NOW(), \n"
                + "        " + userId + ");";

        try {
            statement = connection.prepareStatement(sql);
            statement.setTimestamp(1, startTime);
            statement.setTimestamp(2, endTime);
            statement.execute();
        } catch (Exception e) {

        }
    }

    public Discussion getDiscussionById(int discussionId) {
        Discussion discussion = new Discussion();
        String sql = "SELECT * FROM `discussion` WHERE discussion_id = " + discussionId + ";";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                discussion.setSubjectId(result.getInt(2));
                discussion.setClassCode(result.getString(3));
                discussion.setTitle(result.getString(4));
                discussion.setDescription(result.getString(5));
                discussion.setUserName(result.getString(6));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu | HH:mm");
                Timestamp startTime = result.getTimestamp(7);
                Instant instantStartTime = startTime.toInstant();
                LocalDateTime localStartTime = instantStartTime.atZone(ZoneId.systemDefault()).toLocalDateTime();
                discussion.setFormattedStartTime(localStartTime.format(formatter));

                Timestamp endTime = result.getTimestamp(8);
                Instant instantEndTime = endTime.toInstant();
                LocalDateTime localEndTime = instantEndTime.atZone(ZoneId.systemDefault()).toLocalDateTime();
                discussion.setFormattedEndTime(localEndTime.format(formatter));

                discussion.setStatus(result.getBoolean(9));
                discussion.setCreateAt(result.getDate(10));
                discussion.setCreateBy(result.getInt(11));
                discussion.setUpdateAt(result.getDate(12));
                discussion.setUpdateBy(result.getInt(13));
            }
            return discussion;
        } catch (Exception e) {
            return null;
        }
    }

    public void updateDiscussion(int discussionId, int subjectId, int classId, String title, String description, int userId, Timestamp endTime, boolean status) {
        String sql = "UPDATE discussion\n"
                + "SET\n"
                + "    subject_id = " + subjectId + ",\n"
                + "    class_id = " + classId + ",\n"
                + "    title = '" + title + "',\n"
                + "    description = '" + description + "',\n"
                + "    user_id = " + userId + ",\n"
                + "    end_time = ?,\n"
                + "    status = " + status + ",\n"
                + "    update_at = NOW(),\n"
                + "    update_by = " + userId + "\n"
                + "WHERE discussion_id = " + discussionId + ";";

        try {
            statement = connection.prepareStatement(sql);
            statement.setTimestamp(1, endTime);
            statement.execute();
        } catch (Exception e) {

        }
    }

    public void updateDiscussion(int discussionId, int subjectId, int classId, String title, String description, int userId, boolean status) {
        String sql = "UPDATE discussion\n"
                + "SET\n"
                + "    subject_id = " + subjectId + ",\n"
                + "    class_id = " + classId + ",\n"
                + "    title = '" + title + "',\n"
                + "    description = '" + description + "',\n"
                + "    user_id = " + userId + ",\n"
                + "    status = " + status + ",\n"
                + "    update_at = NOW(),\n"
                + "    update_by = " + userId + "\n"
                + "WHERE discussion_id = " + discussionId + ";";

        try {
            statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {

        }
    }

    public ArrayList<Comment> getCommentByDiscussionId(int discussionId) {
        ArrayList<Comment> commentList = new ArrayList<>();
        String sql = "SELECT\n"
                + "    c.comment_id,\n"
                + "    c.comment,\n"
                + "    u.full_name AS user_name,\n"
                + "    c.discussion_id,\n"
                + "    c.reply_id,\n"
                + "    c.created_at,\n"
                + "    c.create_by,\n"
                + "    c.update_at,\n"
                + "    c.update_by\n"
                + "FROM comment c\n"
                + "INNER JOIN user u ON c.user_id = u.user_id\n"
                + "WHERE c.discussion_id = " + discussionId + ";";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                Comment comment = new Comment();
                comment.setCommentId(result.getInt(1));
                comment.setComment(result.getString(2));
                comment.setFullName(result.getString(3));
                comment.setDiscussionId(result.getInt(4));
                comment.setReplyId(result.getInt(5) == 0 ? 0 : result.getInt(5));
                comment.setUpdateAt(result.getDate(6));
                comment.setCreateBy(result.getInt(7));
                comment.setUpdateAt(result.getDate(8));
                comment.setUpdateBy(result.getInt(9));
                commentList.add(comment);
            }

            return commentList;
        } catch (Exception e) {
            return null;
        }
    }

    public void postCommentWithDiscussionId(int discussionId, String comment, int userId) {
        String sql = "INSERT INTO comment (comment, user_id, discussion_id, reply_id, created_at, create_by, update_at, update_by) VALUES (?, ?, ?, NULL, NOW(), ?, NOW(), ?)";

        try {
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, comment);
            statement.setInt(2, userId);
            statement.setInt(3, discussionId);
            statement.setInt(4, userId);
            statement.setInt(5, userId);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly, e.g., log it or throw a custom exception
        }
    }
    
    public void deleteComment(int commentId) {
        String sql = "DELETE FROM comment WHERE comment_id = " + commentId + "";

        try {
            statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly, e.g., log it or throw a custom exception
        }
    }

}
