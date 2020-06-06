package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
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
public class TaskMapperTest {

    @Autowired
    TaskMapper taskMapper;

    @Test
    public void shouldMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "test", "test");
        Task task = new Task(1L, "test", "test");
        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);
        //Then
        Assert.assertEquals(task, mappedTask);
    }

    @Test
    public void shouldMapToTaskDto() {
        //Given
        Task task = new Task(2L, "test2", "test2");
        TaskDto taskDto = new TaskDto(2L, "test2", "test2");
        //When
        TaskDto mappedTaskDto = taskMapper.mapToTaskDto(task);
        //Then
        Assert.assertEquals(taskDto, mappedTaskDto);
    }

    @Test
    public void shouldMapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1l, "task1", "content1"));
        taskList.add(new Task(2l, "task2", "content2"));
        taskList.add(new Task(3l, "task3", "content3"));

        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(new TaskDto(1l, "task1", "content1"));
        taskDtoList.add(new TaskDto(2l, "task2", "content2"));
        taskDtoList.add(new TaskDto(3l, "task3", "content3"));
        //When
        List<TaskDto> mappedTaskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        Assert.assertEquals(taskDtoList, mappedTaskDtoList);
    }
}
