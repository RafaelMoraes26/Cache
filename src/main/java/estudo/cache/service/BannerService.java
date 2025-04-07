package estudo.cache.service;

import java.time.LocalDateTime;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import estudo.cache.dto.BannerDTO;
import estudo.cache.mapper.BannerMapper;
import estudo.cache.repository.BannerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class BannerService {

    private final BannerRepository repository;

    @Cacheable(value = "bannersUsuario", key = "#id + '-' + #page + '-' + #size")
    public Page<BannerDTO> getActiveBannersFromIdWithCache(String id, Pageable pageable) {
        return repository.findByIdAndActiveIsTrueAndValidDateGreaterThanEqual(id, LocalDateTime.now(), pageable)
            .map(BannerMapper::fromDocumentToDTO);
    }

    public Page<BannerDTO> getActiveBannersFromId(String id, Pageable pageable) {
        return repository.findByIdAndActiveIsTrueAndValidDateGreaterThanEqual(id, LocalDateTime.now(), pageable)
            .map(BannerMapper::fromDocumentToDTO);
    }
}
