package ru.practicum.hit;

import ru.practicum.dto.HitDto;
import ru.practicum.dto.HitInDto;

import java.time.LocalDateTime;
import java.util.List;

public interface HitService {

    List<HitDto> getHits(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique);

    HitInDto saveNewHit(HitInDto hitDto);
}
