# Java Code style guide

## General criterion
- Abide by [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html/)。
- Indent with **4 Spaces** (no tabs).
- Keep no more than **80 characters per line** to improve readability.

## 1. Name convention
- **Class name** : Use PascalCase, for example 'ContactsController'.
- **Method name&Variable name** : Use camelCase, for example, addContact.

## 2. Annotation
- **Method Comments** : Use Javadoc comments to describe the function, parameters, and return value of the method.
- **Inline Comments** : Add short inline comments next to complex logic.

## 3. Code structure
- **Import statement** : Alphabetize and remove unused imports.
- **Comment**: Write on the line above the corresponding method or variable

## 4. Other
- **Using Lombok** : Using Lombok simplifies the writing of getters, setters, and constructors.

## 示例
```java
/**
 * Contact controller
 */
@RestController
@RequestMapping("/Contacts")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ContactsController {
    
    @Autowired
    private ContactService contactService;

    /**
     * Add a new contact
     * 
     * @param contact new contact to be added
     * @return new contact added
     */
    @PostMapping
    public Contacts addContact(@RequestBody Contacts contact) {
        return contactService.addContact(contact);
    }
}
