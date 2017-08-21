package net.atlassian.woohyeok.ao.todo.activeobjects.service;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import net.atlassian.woohyeok.ao.todo.activeobjects.entity.Todo;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.ArrayList;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by kim.woohyeok on 2017/08/21.
 */
@Scanned
@Named
public class ToDoServiceImpl implements ToDoService {
    @ComponentImport
    private final ActiveObjects ao;

    @Inject
    public ToDoServiceImpl(ActiveObjects ao) {
        this.ao = checkNotNull(ao);
    }

    public Todo add(String description) {
        final Todo todo = ao.create(Todo.class);
        todo.setDescription(description);
        todo.setComplete(false);
        todo.save();
        return todo;
    }

    public ArrayList<Todo> all() {
        return newArrayList(ao.find(Todo.class));
    }
}
