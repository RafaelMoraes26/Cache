package estudo.cache.repository.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Banner")
public record BannerDocument(
    @Id String id,
    String title,
    String description,
    String deepLink,
    Boolean active,
    LocalDateTime validDate
) { }
