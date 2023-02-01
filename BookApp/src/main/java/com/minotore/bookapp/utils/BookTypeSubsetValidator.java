package com.minotore.bookapp.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class BookTypeSubsetValidator implements ConstraintValidator<BookTypeSubset, BookType> {
    private BookType[] subset;

    @Override
    public void initialize(BookTypeSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(BookType value, ConstraintValidatorContext context) {
        return value != null && Arrays.asList(subset).contains(value);
    }
}