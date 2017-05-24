package java8.functional;

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
