package ru.practicum.explore_with_me;


import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class EndpointHitAPIDto {
    String app;
    String uri;
    String ip;
    String timestamp;
}
