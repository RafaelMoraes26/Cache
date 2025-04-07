package estudo.cache.controller;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import estudo.cache.dto.BannerDTO;
import estudo.cache.service.BannerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/banner")
@AllArgsConstructor
public class BannerController {

    private final BannerService service;

    @GetMapping("/cache/{id}")
    public Page<BannerDTO> getActiveBannersWithCache(@PathVariable String id,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size,
                                                     @RequestParam(defaultValue = "validDate") String sortBy) {

        log.info("getActiveBannersWithCache from id: {}", id);

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());

        return service.getActiveBannersFromIdWithCache(id, pageable);
    }

    @GetMapping("/no-cache/{id}")
    public Page<BannerDTO> getActiveBannersWithoutCache(@PathVariable String id,
                                                        @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size,
                                                        @RequestParam(defaultValue = "validDate") String sortBy) {

        log.info("getActiveBannersWithoutCache from id: {}", id);

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());

        return service.getActiveBannersFromId(id, pageable);
    }
}
