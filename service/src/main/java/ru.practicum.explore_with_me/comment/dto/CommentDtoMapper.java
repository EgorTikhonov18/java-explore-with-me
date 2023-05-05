package ru.practicum.explore_with_me.comment.dto;


import lombok.experimental.UtilityClass;
import ru.practicum.explore_with_me.comment.model.Comment;

@UtilityClass
public class CommentDtoMapper {
    public static Comment inputToModelMapper(InputCommentDto inputCommentDto) {
        return Comment.builder()
                .text(inputCommentDto.getText())
                .build();
    }

    public static OutputCommentDto modelToOutputMapper(Comment comment) {
        return OutputCommentDto.builder()
                .id(comment.getId())
                .text(comment.getText())
                .event(comment.getEvent())
                .status(comment.getStatus())
                .author(comment.getAuthor())
                .createdOn(comment.getCreatedOn())
                .publishedOn(comment.getPublishedOn())
                .lastEditDate(comment.getLastEditDate())
                .build();
    }
}
//.lastEditDate(comment.getLastEditDate())