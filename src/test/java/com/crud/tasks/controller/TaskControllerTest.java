package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService service;

    @MockBean
    private TaskMapper taskMapper;

    @Test
    public void shouldFetchTasks() throws Exception {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "test", "test"));
        taskList.add(new Task(2L, "test2", "test2"));
        taskList.add(new Task(3L, "test3", "test3"));
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(new TaskDto(1L, "test", "test"));
        taskDtoList.add(new TaskDto(2L, "test2", "test2"));
        taskDtoList.add(new TaskDto(3L, "test3", "test3"));

        when(service.getAllTasks()).thenReturn(taskList);
        when(taskMapper.mapToTaskDtoList(taskList)).thenReturn(taskDtoList);

        //When & Then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[0].title", is("test")))
                .andExpect(jsonPath("$[1].title", is("test2")))
                .andExpect(jsonPath("$[2].title", is("test3")))
                .andExpect(jsonPath("$[0].content", is("test")))
                .andExpect(jsonPath("$[1].content", is("test2")))
                .andExpect(jsonPath("$[2].content", is("test3")));
    }

    @Test
    public void shoudFetchTask() throws Exception {
        //Given
        Task task = new Task(1L, "test", "test");
        TaskDto taskDto = new TaskDto(1L, "test", "test");
        when(service.getTask(1L)).thenReturn(Optional.ofNullable(task));
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);

        //When & Then
        mockMvc.perform(get("/v1/task/getTask?taskId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("test")))
                .andExpect(jsonPath("$.content", is("test")));
    }

    @Test
    public void shouldDeleteTask() throws Exception {
        //Given
        Task task = new Task(2L, "test2", "test2");

        //When & Then
        mockMvc.perform(delete("/v1/task/deleteTask?taskId=2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateTask() throws Exception {
        //Given
        Task task = new Task(3L, "test3", "test3");
        TaskDto taskDto = new TaskDto(3L, "test3", "test3");
        when(service.saveTask(task)).thenReturn(task);
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        when(taskMapper.mapToTask(ArgumentMatchers.any())).thenReturn(task);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        //When & Then
        mockMvc.perform(put("/v1/task/updateTask").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk()).andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.title", is("test3")))
                .andExpect(jsonPath("$.content", is("test3")));
    }

    @Test
    public void shouldCreateTask() throws Exception {
        //Given
        Task task = new Task(3L, "test3", "test3");
        TaskDto taskDto = new TaskDto(null,"test3", "test3");
        when(service.saveTask(task)).thenReturn(task);
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        //When & Then
        mockMvc.perform(post("/v1/task/createTask").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}
