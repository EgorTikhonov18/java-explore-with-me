package ru.practicum.explore_with_me.comment.controller;



import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.explore_with_me.comment.dto.InputCommentDto;
import ru.practicum.explore_with_me.comment.dto.OutputCommentDto;
import ru.practicum.explore_with_me.comment.service.CommentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users/{userId}/comments")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrivateCommentController {
    final String PATH_VAR_USERID = "userId";
    final String PATH_VAR_COMMENTID = "commentId";
    final String PATH_VAR_EVENTID = "eventId";
    final String PATH_FOR_COMMENTID = "/{commentId}";

    final CommentService commentService;

    @Autowired
    public PrivateCommentController(@Qualifier("CommentServiceDb") CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public OutputCommentDto addComment(@Valid @RequestBody InputCommentDto inputCommentDto,
                                       @PathVariable(name = PATH_VAR_USERID) Long userId,
                                       @RequestParam(name = PATH_VAR_EVENTID) Long eventId) {
        return commentService.addComment(inputCommentDto, userId, eventId);
    }

    @PatchMapping(PATH_FOR_COMMENTID)
    public OutputCommentDto updateComment(@Valid @RequestBody InputCommentDto inputCommentDto,
                                          @PathVariable(name = PATH_VAR_USERID) Long userId,
                                          @PathVariable(name = PATH_VAR_COMMENTID) Long commentId) {
        return commentService.updateComment(inputCommentDto, userId, commentId);
    }

    @DeleteMapping(PATH_FOR_COMMENTID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable(name = PATH_VAR_USERID) Long userId,
                              @PathVariable(name = PATH_VAR_COMMENTID) Long commentId) {
        commentService.deleteComment(userId, commentId);
    }

    @GetMapping
    public List<OutputCommentDto> getOwnComments(@PathVariable(name = PATH_VAR_USERID) Long userId) {
        return commentService.getOwnComments(userId);
    }
}