package builder;

import org.testng.annotations.Test;

public class BuilderTest {
    @Test
    public void testBuilder() {
        BankAccount newAccount1 = new BankAccount
                .BankAccountBuilder("Bruno", "2224312423423")
                .withEmail("exampleEmail@gmail.com")
                .wantNewsletter(false)
                .build();
        assert newAccount1.getName().equals("Bruno");
        assert newAccount1.getAccountNumber().equals("2224312423423");
        assert newAccount1.getEmail().equals("exampleEmail@gmail.com");
        assert !newAccount1.wantsNewsletter();

        BankAccount newAccount2 = new BankAccount
                .BankAccountBuilder("Mihovilic", "12344325434543")
                .withEmail("exampleEmail2@gmail.com")
                .wantNewsletter(true)
                .build();
        assert newAccount2.getName().equals("Mihovilic");
        assert newAccount2.getAccountNumber().equals("12344325434543");
        assert newAccount2.getEmail().equals("exampleEmail2@gmail.com");
        assert newAccount2.wantsNewsletter();
    }
}