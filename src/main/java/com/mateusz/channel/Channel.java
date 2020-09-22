package com.mateusz.channel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Channel {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
}
