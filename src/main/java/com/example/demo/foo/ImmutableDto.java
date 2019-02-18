package com.example.demo.foo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor=@__(@JsonCreator))
public class ImmutableDto {
    
    @JsonProperty
    String foo;
    
    @JsonProperty(required = true)
    String fizz;
    
}
