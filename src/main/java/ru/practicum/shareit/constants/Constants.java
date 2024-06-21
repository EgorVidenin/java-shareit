package ru.practicum.shareit.constants;


public class Constants {
    public static final String X_SHARER_USER_ID = "X-Sharer-User-Id";
    public static final String MESSAGE_FOR_DUPLICATE_EMAIL = "This Email is already registered: ";
    public static final String MESSAGE_BAD_OWNER_ID = "Wrong owner ID: ";
}

// не разобрался

//import org.springframework.beans.factory.annotation.Value;
//        import org.springframework.stereotype.Component;
//
//@Component
//public class Constants {
//    @Value("${shareit.constants.x-sharer-user-id}")
//    public static String X_SHARER_USER_ID;
//
//    @Value("${shareit.constants.message-for-duplicate-email}")
//    public static String MESSAGE_FOR_DUPLICATE_EMAIL;
//
//    @Value("${shareit.constants.message-bad-owner-id}")
//    public static String MESSAGE_BAD_OWNER_ID;
//}