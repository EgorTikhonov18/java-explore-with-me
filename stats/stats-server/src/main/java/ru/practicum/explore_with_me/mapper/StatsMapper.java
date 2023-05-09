package ru.practicum.explore_with_me.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.practicum.explore_with_me.EndpointHitDto;
import ru.practicum.explore_with_me.ViewStatsDto;
import ru.practicum.explore_with_me.model.EndpointHit;
import ru.practicum.explore_with_me.model.ViewStats;

@Mapper
public interface StatsMapper {

    StatsMapper STATS_MAPPER = Mappers.getMapper(StatsMapper.class);

    EndpointHitDto toEndpointHitDto(EndpointHit endpointHit);

    EndpointHit toEndpointHit(EndpointHitDto endpointHitDto);

    ViewStatsDto toViewStatsDto(ViewStats viewStats);
}