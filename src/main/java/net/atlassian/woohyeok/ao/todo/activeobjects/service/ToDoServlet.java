package net.atlassian.woohyeok.ao.todo.activeobjects.service;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.sal.api.transaction.TransactionCallback;
import net.atlassian.woohyeok.ao.todo.activeobjects.entity.Todo;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kim.woohyeok on 2017/08/17.
 */

@Scanned
public class ToDoServlet extends HttpServlet {

    private final ToDoService toDoService;

    @Inject
    public ToDoServlet(ToDoService toDoService) {
        this.toDoService = checkNotNull(toDoService);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter w = resp.getWriter();
        w.write("<h1>Todos</h1>");

        // the form to post more TODOs
        w.write("<form method=\"post\">");
        w.write("<input type=\"text\" name=\"task\" size=\"25\"/>");
        w.write("&nbsp;&nbsp;");
        w.write("<div><input type=\"submit\" name=\"submit\" style=\"float:left\" value=\"Add\"/></div>");
        w.write("</form>");
        w.write("<div><input type=\"submit\" name=\"submit\" style=\"float:left\"  value=\"Complete\"/></div>");

        w.write("<ol>");

/*        ao.executeInTransaction(new TransactionCallback<Void>() // (1)
        {
            public Void doInTransaction() {
                for (Todo todo : ao.find(Todo.class)) // (2)
                {
                    w.printf("<li><%2$s> %s </%2$s></li>", todo.getDescription(), todo.isComplete() ? "strike" : "strong");
                }
                return null;
            }
        });*/

        for (Todo todo : toDoService.all()) {
            w.printf("<li><%2$s> %s </%2$s><input type=\"checkbox\" name=\"check\"/></li>", todo.getDescription(), todo.isComplete() ? "strike" : "strong");
        }

        w.write("</ol>");
        w.write("<script language='javascript'>document.forms[0].elements[0].focus();</script>");

        w.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String description = req.getParameter("task");
/*        ao.executeInTransaction(new TransactionCallback<Todo>() {
            public Todo doInTransaction() {
                final Todo todo = ao.create(Todo.class);
                todo.setDescription(description);
                todo.setComplete(false);
                todo.save();
                return todo;
            }
        });*/
        toDoService.add(description);
        resp.sendRedirect(req.getContextPath() + "/plugins/servlet/todo/list");
    }


}
