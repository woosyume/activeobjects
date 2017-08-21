package net.atlassian.woohyeok.ao.todo.activeobjects.service;

import com.atlassian.activeobjects.tx.Transactional;
import net.atlassian.woohyeok.ao.todo.activeobjects.entity.Todo;

import java.util.ArrayList;

/**
 * Created by kim.woohyeok on 2017/08/21.
 */


/*
* 既存ToDoServletの無名クラスを、インターフェースとして実装：after JIRA 6.0 ... @Transactional
* 【実装例】
*         ao.executeInTransaction(new TransactionCallback<Void>() // (1)
        {
            public Void doInTransaction() {
                for (Todo todo : ao.find(Todo.class)) // (2)
                {
                    w.printf("<li><%2$s> %s </%2$s></li>", todo.getDescription(), todo.isComplete() ? "strike" : "strong");
                }
                return null;
            }
        });
*
* */
@Transactional
public interface ToDoService {
    Todo add(String description);
    ArrayList<Todo> all();
}
