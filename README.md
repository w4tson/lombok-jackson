An Experiment to "work out" Immutable Lombok DTO's and Jackson.

There's nothing to work out, just add `@AllArgsConstructor(onConstructor=@__(@JsonCreator))` 
