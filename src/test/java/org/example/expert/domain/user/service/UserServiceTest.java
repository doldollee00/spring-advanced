//package org.example.expert.domain.user.service;
//
//import org.example.expert.domain.common.exception.InvalidRequestException;
//import org.example.expert.domain.user.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.BDDMockito.given;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//    @InjectMocks
//    private UserService userService;
//
//
//
//    @Test
//    public void user_목록_조회_시_user가_없다면_IRE_에러를_던진다() {
//        // given
//        long userId = 1L;
//        given(userRepository.findById(userId)).willReturn(Optional.empty());    //이게 중요한거야, empty를 반환하겠다고 함
//
//        // when & then
//        InvalidRequestException exception = assertThrows(InvalidRequestException.class, () -> userService.getUser(userId));
//        assertEquals("User not found", exception.getMessage());
//    }
//
//
//}
