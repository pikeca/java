package com.java.learn;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 二雷
 * @date 2018/07/26
 */
@Data
public class Person implements Serializable {
    @JSONField(name="user_name")
    private String name;
    private Integer age;
    private byte[] type;
    private Anaimal anaimal;
}
