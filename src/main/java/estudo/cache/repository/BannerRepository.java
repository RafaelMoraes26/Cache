package estudo.cache.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import estudo.cache.repository.document.BannerDocument;

@Repository
public interface BannerRepository extends MongoRepository<BannerDocument, String> {

    Page<BannerDocument> findByIdAndActiveIsTrueAndValidDateGreaterThanEqual(String id, LocalDateTime now, Pageable pageable);

}
