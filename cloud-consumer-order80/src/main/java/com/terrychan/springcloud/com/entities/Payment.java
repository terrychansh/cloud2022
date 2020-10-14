package com.terrychan.springcloud.com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private long id;
    private String serial;
}
