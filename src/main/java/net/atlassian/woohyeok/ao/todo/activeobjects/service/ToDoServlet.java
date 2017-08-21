package net.atlassian.woohyeok.ao.todo.activeobjects.service;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kim.woohyeok on 2017/08/17.
 */

@Scanned
public class ToDoServlet extends HttpServlet {

    @ComponentImport
    private final ActiveObjects ao;

    @Inject
    public ToDoServlet(ActiveObjects ao) {
        this.ao = checkNotNull(ao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Todo servlet, doGet");
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Todo servlet, doPost");
        resp.getWriter().close();
    }


}
