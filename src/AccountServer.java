/**
 * Created by erik on 2017-04-09.
 */
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;


public class AccountServer extends HttpServlet{
    public ArrayList<Account> accList = new ArrayList<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        PrintWriter out = response.getWriter();

        // add example accounts
        Account myAccount1 = new Account("12345", new BigDecimal(10), "USD", true, new ArrayList<String>(){{add("bob");}}, new ArrayList<Asset>(){{add(new Asset("test1", new BigDecimal(100))); add(new Asset("test4", new BigDecimal(10.2)));}} );
        Account myAccount2 = new Account("11111", new BigDecimal(30), "SGD", true, new ArrayList<String>(){{add("john");}}, new ArrayList<Asset>(){{add(new Asset("test2", new BigDecimal(101)));}} );
        accList.add(myAccount1);
        accList.add(myAccount2);

        out.println(getAccount(getAccountID(request)));


    }

    public Account getAccount(String accountID){
        for (Account account : accList){
            if (account.getAccountID().equals(accountID)){
                return account;
            }
        }
        return null;
    }

    public String getAccountID(HttpServletRequest request){
        return  request.getHeader("accountID");
    }
}
