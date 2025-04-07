package estudo.cache.mapper;

import org.springframework.stereotype.Component;

import estudo.cache.dto.BannerDTO;
import estudo.cache.repository.document.BannerDocument;

@Component
public class BannerMapper {

    public static BannerDTO fromDocumentToDTO(BannerDocument doc) {
        return new BannerDTO(
            doc.title(),
            doc.description(),
            doc.deepLink()
        );
    }
}
