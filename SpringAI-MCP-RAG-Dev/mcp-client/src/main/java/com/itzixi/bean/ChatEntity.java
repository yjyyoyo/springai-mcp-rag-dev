package com.itzixi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName ChatEntity
 * @Author 风间影月
 * @Version 1.0
 * @Description ChatEntity
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChatEntity {

    private String currentUserName;
    private String message;
    private String botMsgId;

}
