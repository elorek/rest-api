package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void shouldMapToList() {
        //Given
        List<TrelloListDto> testList = new ArrayList<>();
        testList.add(new TrelloListDto("1", "testedListDto", true));
        //When
        List<TrelloList> mappedList = trelloMapper.mapToList(testList);
        //Then
        Assert.assertEquals(1, mappedList.size());
        Assert.assertEquals("1", mappedList.get(0).getId());
        Assert.assertEquals("testedListDto", mappedList.get(0).getName());
    }

    @Test
    public void shouldMapToListDto() {
        //Given
        List<TrelloList> testList = new ArrayList<>();
        testList.add(new TrelloList("1", "testedList", true));
        //When
        List<TrelloListDto> mappedList = trelloMapper.mapToListDto(testList);
        //Then
        Assert.assertEquals(1, mappedList.size());
        Assert.assertEquals("1", mappedList.get(0).getId());
        Assert.assertEquals("testedList", mappedList.get(0).getName());
    }

    @Test
    public void shouldMapToBoards() {
        //Given
        List<TrelloListDto> testList = new ArrayList<>();
        testList.add(new TrelloListDto("1", "testedListDto", true));
        List<TrelloBoardDto> testboardDtoList = new ArrayList<>();
        testboardDtoList.add(new TrelloBoardDto("1", "testedBoardDto", testList));
        //When
        List<TrelloBoard> mappedBoardList = trelloMapper.mapToBoards(testboardDtoList);
        //Then
        Assert.assertEquals(1, mappedBoardList.size());
        Assert.assertEquals("1", mappedBoardList.get(0).getId());
        Assert.assertEquals("testedBoardDto", mappedBoardList.get(0).getName());
    }

    @Test
    public void shouldMapToBoardsDto() {
        //Given
        List<TrelloList> testList = new ArrayList<>();
        testList.add(new TrelloList("1", "testedList", true));
        List<TrelloBoard> testBoard = new ArrayList<>();
        testBoard.add(new TrelloBoard("1", "testedBoard", testList));

        //When
        List<TrelloBoardDto> mappedBoardDtoList = trelloMapper.mapToBoardsDto(testBoard);
        //Then
        Assert.assertEquals(1, mappedBoardDtoList.size());
        Assert.assertEquals("1", mappedBoardDtoList.get(0).getId());
        Assert.assertEquals("testedBoard", mappedBoardDtoList.get(0).getName());
    }

    @Test
    public void shouldMapToCard() {
        //Given
        TrelloCardDto testCardDto = new TrelloCardDto("trelloCard", "cardDescription", "top", "2");
        TrelloCard card = new TrelloCard("trelloCard", "cardDescription", "top", "2");
        //When
        TrelloCard mappedCard = trelloMapper.mapToCard(testCardDto);
        //Then
        Assert.assertEquals(card, mappedCard);
    }

    @Test
    public void shouldMapToCardDto() {
        //Given
        TrelloCard testCard = new TrelloCard("trelloCard", "cardDescription", "top", "2");
        TrelloCardDto cardDto = new TrelloCardDto("trelloCard", "cardDescription", "top", "2");
        //When
        TrelloCardDto mappedCardDto = trelloMapper.mapToCardDto(testCard);
        //Then
        Assert.assertEquals(cardDto, mappedCardDto);
    }
}
