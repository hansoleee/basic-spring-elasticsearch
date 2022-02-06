package com.hansoleee.basicspringelk.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Field;

import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author {

    @Field(type = Text)
    private String name;

    public Author(String name) {
        this.name = name;
    }
}
