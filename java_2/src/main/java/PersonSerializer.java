import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.example.Person;

import java.io.IOException;
public class PersonSerializer extends JsonSerializer<Person> {
    @Override
    public void serialize(Person person, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("lastName", person.getLastName());
        jsonGenerator.writeStringField("firstName", person.getFirstName());
        jsonGenerator.writeNumberField("age", person.getAge());
        jsonGenerator.writeEndObject();
    }
}