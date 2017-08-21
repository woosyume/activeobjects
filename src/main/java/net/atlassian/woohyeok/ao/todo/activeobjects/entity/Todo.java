package net.atlassian.woohyeok.ao.todo.activeobjects.entity;

import net.java.ao.Entity;

/**
 * Created by kim.woohyeok on 2017/08/17.
 */
public interface Todo extends Entity {
    String getDescription();
    void setDescription(String description);
    boolean isComplete();
    void setComplete(boolean complete);
}
