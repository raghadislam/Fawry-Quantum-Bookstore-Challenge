package Validation;

public class BookValidationChain {
    public static BookValidator defaultChain() {
        BookValidator head = new NameValidator();
        head.linkWith(new PriceValidator())
                .linkWith(new YearValidator());
        return head;
    }
}