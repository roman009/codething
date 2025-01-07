package io.codething;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class User {
    private UUID id;
    private int bmr;
}
