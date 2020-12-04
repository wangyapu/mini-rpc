package com.mini.rpc.protocol;

import lombok.Data;

import java.io.Serializable;

@Data
public class MsgHeader implements Serializable {
    /*
    +---------------------------------------------------------------+
    | 魔数 2byte | 协议版本号 1byte | 序列化算法 1byte | 报文类型 1byte  |
    +---------------------------------------------------------------+
    | 状态 1byte |        消息 ID 8byte     |      数据长度 4byte     |
    +---------------------------------------------------------------+
    */

    private short magic;
    private byte version;
    private byte serialization;
    private byte msgType;
    private byte status;
    private long requestId;
    private int msgLen;
}
