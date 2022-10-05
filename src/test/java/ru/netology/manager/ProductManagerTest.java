package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(11, "Война и мир", 500, "Толстой");
    private Book book2 = new Book(22, "Мертвые души", 450, "Гоголь");
    private Smartphone phone1 = new Smartphone(111, "iphone", 50000, "Apple");


    @Test
    public void shouldFindAll() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, phone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByWord() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        Product[] actual = manager.searchBy("души");
        Product[] expected = new Product[]{book2};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindByWord2() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        Product[] actual = manager.searchBy("мир");
        Product[] expected = new Product[]{book1};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindBySmartphonesName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        Product[] actual = manager.searchBy("iphone");
        Product[] expected = new Product[]{phone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindIfAdded() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        Product product = new Product(444, "KKKK", 200);
        manager.add(product);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1, book2, phone1, product};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        repository.removeById(11);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book2, phone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void setId() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        Product product = new Product();

        product.setId(22);

        Product[] actual = new Product[]{book2};
        Product[] expected = new Product[]{book2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void setPrice() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        Product product = new Product();

        product.setPrice(450);

        Product[] actual = new Product[]{book2};
        Product[] expected = new Product[]{book2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void setName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        Product product = new Product();

        product.setName("Война и мир");

        Product[] actual = new Product[]{book1};
        Product[] expected = new Product[]{book1};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void getPrice() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        Product product = new Product();

        product.getPrice();

        Product[] actual = new Product[]{book1, book2, phone1};
        Product[] expected = new Product[]{book1, book2, phone1};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        Product[] actual = manager.searchBy("999");
        Product[] expected = new Product[]{};
        Assertions.assertArrayEquals(expected, actual);

    }
}

