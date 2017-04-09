import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Account implements Serializable {

    /* unique id of the account */
    public String accountID;

    /* present value of the account in the given currency */
    public BigDecimal accountValue;

    /* currency abbreviation, such as USD, HKD, SGD */
    public String currency;

    /* true if accout is active, false if under review */
    public boolean isAccountActive;

    /* list of the people that own the account */
    public ArrayList<String> accountOwnersNames;

    /* Assets held in the account */
    public ArrayList<Asset> holdings;


    public Account(String accountID, BigDecimal accountValue, String currency, boolean isAccountActive, ArrayList<String> accountOwnersNames, ArrayList<Asset> holdings) {
        this.accountID = accountID;
        this.accountValue = accountValue;
        this.currency = currency;
        this.isAccountActive = isAccountActive;
        this.accountOwnersNames = accountOwnersNames;
        this.holdings = holdings;
    }

    public String getAccountID(){
        return accountID;
    }

    @Override
    public String toString() {
        String ownerNamesString = String.join(",", accountOwnersNames);
        String holdingsString = holdings.stream().map(Object::toString).collect(Collectors.joining(""));
        return "AccountID: " + accountID + '\n'
                + "AccountValue: " +  accountValue + '\n'
                + "AccountCurrency: " + currency + '\n'
                + "AccountIsActive: " + isAccountActive + '\n'
                + "ownerNames: " + ownerNamesString + '\n'
                + "holdings: " + holdingsString + '\n';
    }
}
