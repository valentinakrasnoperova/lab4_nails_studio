package nailsstudio.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonUtil {
    public static <T> T deserialize(final String source, final Class<T> t) {
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(source, t);
        } catch (final IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}