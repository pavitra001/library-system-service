package com.target.ready.library.system.service.LibrarySystemService.Service;

import com.target.ready.library.system.service.LibrarySystemService.Entity.BookCategory;
import com.target.ready.library.system.service.LibrarySystemService.Entity.Category;
import com.target.ready.library.system.service.LibrarySystemService.Repository.BookCategoryRepository;
import com.target.ready.library.system.service.LibrarySystemService.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookCategoryRepository bookCategoryRepository;

    public Category addCategory(Category category){
        return categoryRepository.save(category);

    }

    public Category findByCategoryName(String categoryName){
        Category category=categoryRepository.findBycategoryName(categoryName);
        return category;
    }

    public BookCategory findByBookId(int bookId){
        BookCategory bookCategory=bookCategoryRepository.findByBookId(bookId);
        return bookCategory;
    }
    public void deleteCategoriesByBookId(int bookId){
        List<BookCategory> bookCategories = bookCategoryRepository.findAllCategoriesByBookId(bookId);
        for (BookCategory bookCategory:bookCategories
        ) {
            categoryRepository.deleteCategoryByCategoryName(bookCategory.getCategoryName());
        }
    }

    public String deleteBookCategoryByBookId(int bookId){
        bookCategoryRepository.deleteBookCategoriesByBookId(bookId);
        return "Book category deleted";
    }
    public BookCategory addBookCategory(BookCategory bookCategory){
        return bookCategoryRepository.save(bookCategory);

    }

    public String deleteBookCategory(int id){

        bookCategoryRepository.deleteById(id);
        return "Deleted";
    }

    public List<Category> getAllCategories(){

        return categoryRepository.findAll();
    }

    public List<BookCategory> findAllCategoriesByBookId(int bookId){
        List<BookCategory> bookCategories=bookCategoryRepository.findAllCategoriesByBookId(bookId);
        return bookCategories;
    }
}
