package evanther.resteasy.server.other;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import evanther.resteasy.server.entity.User;

@Provider
@Produces(MediaType.APPLICATION_XML)
public class UserXmlWriter { // implements MessageBodyWriter<User> {

    // @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    // @Override
    public long getSize(User t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    // @Override
    public void writeTo(User user, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException,
            WebApplicationException {

        PrintWriter writer = new PrintWriter(entityStream);
        writer.print("<user><id>" + user.getId() + "</id><nombre>" + user.getName() + "</nombre></user>");

        writer.flush();
        writer.close();
    }

}
