package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TrelloCardDto {
    private String name;
    private String description;
    private String pos;
    private String listId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrelloCardDto)) return false;
        TrelloCardDto that = (TrelloCardDto) o;
        return name.equals(that.name) &&
                description.equals(that.description) &&
                pos.equals(that.pos) &&
                listId.equals(that.listId);
    }
}
