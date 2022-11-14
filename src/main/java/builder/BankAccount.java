package builder;

public class BankAccount {
    private final String name;
    private final String accountNumber;
    private final String email;
    private final boolean newsletter;

    private BankAccount(BankAccountBuilder bankAccountBuilder) {
        this.name = bankAccountBuilder.name;
        this.accountNumber = bankAccountBuilder.accountNumber;
        this.email = bankAccountBuilder.email;
        this.newsletter = bankAccountBuilder.newsletter;
    }

    public static class BankAccountBuilder {
        private final String name;
        private final String accountNumber;
        private String email;
        private boolean newsletter;
        
        public BankAccountBuilder(String name, String accountNumber) {
            this.name = name;
            this.accountNumber = accountNumber;
        }
        
        public BankAccountBuilder withEmail(String email) {
            this.email = email;
            return this;
        }
        
        public BankAccountBuilder wantNewsletter(boolean newsletter) {
            this.newsletter = newsletter;
            return this;
        }
        
        public BankAccount build() {
            return new BankAccount(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getEmail() {
        return email;
    }

    public boolean wantsNewsletter() {
        return newsletter;
    }
}