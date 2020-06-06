package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TrelloCard {
    private String name;
    private String description;
    private String pos;
    private String listId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrelloCard)) return false;
        TrelloCard that = (TrelloCard) o;
        return name.equals(that.name) &&
                description.equals(that.description) &&
                pos.equals(that.pos) &&
                listId.equals(that.listId);
    }
}
