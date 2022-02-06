package com.hansoleee.basicspringelk.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(indexName = "blog")
public class Article {

    @Id
    private String id;

    @MultiField(mainField = @Field(type = Text, fielddata = true), otherFields = {@InnerField(suffix = "verbatim", type = Keyword)})
    private String title;

    @Field(type = Nested, includeInParent = true)
    private List<Author> authors;

    @Field(type = Keyword)
    private String[] tags;

    public void setTags(String ... tags) {
        this.tags = tags;
    }

    public Article(String title) {
        this.title = title;
    }
}
