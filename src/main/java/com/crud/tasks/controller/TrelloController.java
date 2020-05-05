package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/trello")
@CrossOrigin("*")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {

//        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

//        trelloBoards.stream().filter(trelloBoardDto -> trelloBoardDto.getName().equals("kodilla"))
//                .filter(trelloBoardDto -> trelloBoardDto.getId().contains("id"))
//                .forEach(System.out::println);
//            System.out.println("This board contains lists: ");
//            trelloBoardDto.getLists().forEach(trelloList -> System.out.println(trelloList.getId() +
//                    " - " + trelloList.getName() + " - " + trelloList.isClosed()));

        return trelloClient.getTrelloBoards();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }
}
