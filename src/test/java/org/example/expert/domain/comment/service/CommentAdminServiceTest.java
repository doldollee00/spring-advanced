package org.example.expert.domain.comment.service;

import org.example.expert.domain.comment.dto.request.CommentSaveRequest;
import org.example.expert.domain.comment.entity.Comment;
import org.example.expert.domain.comment.repository.CommentRepository;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.entity.User;
import org.example.expert.domain.user.enums.UserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class CommentAdminServiceTest {

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentAdminService commentAdminService;

    @Test
    public void CommentAdmin댓글삭제가_정상적으로_작동한다() {

        // given
        long todoId = 1;
        CommentSaveRequest request = new CommentSaveRequest("contents");
        AuthUser authUser = new AuthUser(1L, "email", UserRole.ADMIN);
        User user = User.fromAuthUser(authUser);
        Todo todo = new Todo("title", "title", "contents", user);

        Comment comment = new Comment(request.getContents(), user, todo);
        List<Comment> commentList = List.of(comment);

        given(commentRepository.findByTodoIdWithUser(anyLong())).willReturn(commentList);

        // when
        commentAdminService.deleteComment(todoId);

        // then
        verify(commentRepository, times(1)).deleteById(todoId);
    }
}
