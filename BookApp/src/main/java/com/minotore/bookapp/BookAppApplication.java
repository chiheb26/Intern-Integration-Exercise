package com.minotore.bookapp;

import com.minotore.bookapp.models.*;
import com.minotore.bookapp.repositories.*;
import com.minotore.bookapp.utils.CategoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class BookAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BookAppApplication.class, args);
    }
    @Bean
    public ErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes() {

            @Override
            public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {

                Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
                errorAttributes.remove("timestamp");
                errorAttributes.remove("path");
                return errorAttributes;
            }

        };
    }
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MagazineRepository magazineRepository;
    @Autowired
    private NovelRepository novelRepository;

    @Override
    public void run(String... args) throws Exception {
        if(libraryRepository.findAll().isEmpty()) {
            Library library = new Library();
            library.setName("The Artists");
            libraryRepository.save(library);

            Category category = new Category();
            category.setCategoryType(CategoryType.COOKING);
            categoryRepository.save(category);

            Author author = new Author();
            author.setAge(18);
            author.setName("author1");
            authorRepository.save(author);



            Magazine magazine = new Magazine();
            magazine.setAuthor(author);
            magazine.setLibrary(library);
            magazine.setNextReleaseDate(new Date(System.currentTimeMillis() + 99999 * 9999));
            magazine.setKeywords(Arrays.asList("keyword1", "keyword2").stream().collect(Collectors.toList()));
            magazine.addCategory(category);
            magazine.setTitle("magazine1");
            magazine.setPrice(10.0);
            magazine.setTotalUnitsSold(250L);
            magazine.setPublicationDate(new Date());
            magazine.setNumberOfPages(55);
            //magazineRepository.save(magazine);

            Magazine mg = new Magazine();
            mg.setNextReleaseDate(new Date(System.currentTimeMillis()+99999));
            mg.setKeywords(Arrays.asList("keyword3","keyword4").stream().collect(Collectors.toList()));
            mg.setAuthor(author);
            mg.setLibrary(library);
            mg.addCategory(category);
            mg.setTitle("mg");
            mg.setPrice(20.0);
            mg.setTotalUnitsSold(200L);
            mg.setPublicationDate(new Date());
            mg.setNumberOfPages(20);
            //magazineRepository.saveAndFlush(mg);
            magazineRepository.saveAll((Arrays.asList(magazine,mg).stream().collect(Collectors.toList())));


            Novel novel = new Novel();
            novel.setAuthor(author);
            novel.setLibrary(library);
            novel.setStorySummary("summary1");
            novel.addCategory(category);
            novel.setTitle("novel");
            novel.setPrice(20.0);
            novel.setTotalUnitsSold(40L);
            novel.setPublicationDate(new Date());
            novel.setNumberOfPages(44);
            novelRepository.save(novel);

            Novel novel2 = new Novel();
            novel2.setAuthor(author);
            novel2.setLibrary(library);
            novel2.setStorySummary("summary2");
            novel2.addCategory(category);
            novel2.setTitle("novel2");
            novel2.setPrice(40.0);
            novel2.setTotalUnitsSold(75L);
            novel2.setPublicationDate(new Date());
            novel2.setNumberOfPages(52);
            novelRepository.save(novel2);

            Novel novel3 = new Novel();
            novel3.setAuthor(author);
            novel3.setLibrary(library);
            novel3.setStorySummary("summary3");
            novel3.addCategory(category);
            novel3.setTitle("novel3");
            novel3.setPrice(60.0);
            novel3.setTotalUnitsSold(800L);
            novel3.setPublicationDate(new Date());
            novel3.setNumberOfPages(62);
            novelRepository.save(novel3);
        }
    }
}
