package ut.net.atlassian.woohyeok.ao.todo;

import org.junit.Test;
import net.atlassian.woohyeok.ao.todo.api.MyPluginComponent;
import net.atlassian.woohyeok.ao.todo.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}