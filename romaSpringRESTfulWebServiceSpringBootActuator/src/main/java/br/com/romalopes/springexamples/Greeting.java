package br.com.romalopes.springexamples;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 23/11/13
 * Time: 21:29
 * To change this template use File | Settings | File Templates.
 */
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}