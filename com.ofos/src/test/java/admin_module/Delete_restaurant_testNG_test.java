package admin_module;

import org.testng.annotations.Test;

import com.ofos.GenericUtility.Baseclass;
import com.ofos.Objectrepo.Add_menu_page;
import com.ofos.Objectrepo.Dashboard_page;

public class Delete_restaurant_testNG_test extends Baseclass
{
@Test
public void delete()
{

Dashboard_page dbp = new Dashboard_page(driver);
dbp.dltmenu();

Add_menu_page amp = new Add_menu_page(driver);
amp.delete();

}
}