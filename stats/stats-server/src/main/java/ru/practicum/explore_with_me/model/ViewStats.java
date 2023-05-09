package ru.practicum.explore_with_me.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ViewStats {
    String app;
    String uri;
    Long hits;
}