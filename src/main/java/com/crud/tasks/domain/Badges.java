package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Badges {
    @JsonProperty("votes")
    private int votes;

    @JsonProperty("attachments")
    private AttachmentByType attachments;
}
