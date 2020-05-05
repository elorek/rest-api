package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTrelloCard {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("shortUrl")
    private String shortUrl;

    @JsonProperty("badges")
    private Badges badges;



//        JsonFactory factory = new JsonFactory();
//        ObjectMapper mapper = new ObjectMapper();
//        JsonParser jsonParser = factory.createParser(jsonResponse);
//        //JsonParser jsonParser = factory.createParser(jsonToObject().) ?????
//        MappingIterator<CreatedTrelloCard> createdTrelloCardMappingIterator = mapper.readValues(jsonParser, CreatedTrelloCard.class);
//        List<CreatedTrelloCard> createdTrelloCardList = createdTrelloCardMappingIterator.readAll();
//        return createdTrelloCardList;


}
