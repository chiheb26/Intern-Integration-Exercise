package com.minotore.bookapp.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class CategoryTypeSubsetValidator implements ConstraintValidator<CategoryTypeSubset, CategoryType> {
    private CategoryType[] subset;

    @Override
    public void initialize(CategoryTypeSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(CategoryType value, ConstraintValidatorContext context) {
        return false;
    }


}