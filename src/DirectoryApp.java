import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.HashMap;

/**
 * Description.
 */
public class DirectoryApp extends Application<DirectoryConfig>
{
/*    private Departments deps;
    private Employees emps;
*/
    public static void main(String[] args) throws Exception {
        new DirectoryApp().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<DirectoryConfig> bootstrap) {
        // nothing to do yet
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
    }

    @Override
    public void run(DirectoryConfig configuration,
                    Environment environment) {
        environment.jersey().setUrlPattern("/api/*");
/*        final DepartmentsResource depsr = new DepartmentsResource(deps);
        final EmployeesResource empsr = new EmployeesResource(emps);
        final DepartmentResource depr = new DepartmentResource(deps);
        final DepartmentEmployeeResource depempr = new DepartmentEmployeeResource(deps,emps);
        final DepartmentEmployeesResource depempsr = new DepartmentEmployeesResource(deps);
        environment.jersey().register(depsr);
        environment.jersey().register(empsr);
        environment.jersey().register(depr);
        environment.jersey().register(depempr);
        environment.jersey().register(depempsr);
*/    }

    public DirectoryApp() {
        /*deps = new Departments(new HashMap<String,Department>());
        emps = new Employees(new HashMap<Long,Employee>());
    */}

}