# University Console Application

The whole application can be separated to several layers (which is presented in source by packages):

## Controller
### Console Endpoint
Console endpoint of the application. Currently supports next console commands:
 <ul>
 <li><b><i>Who is head of department {department_name}</i></b></li>
 <li><b><i>Show {department_name} statistics</i></b></li>
 <li><b><i>Show the average salary for the department {department_name}</i></b></li>
 <li><b><i>Show count of employee for {department_name}</i></b></li>
 <li><b><i>Global search by {template}</i></b></li>
 <li><b><i>exit</i></b> - shuts down the application.</li>
 </ul>
 
### DispatcherController
 <p>
 Controller, that matches requests, forwarded from command line,
 to the correct request pattern and invokes the corresponding
 service method.
 </p>
 <p>
 Uses an implemented Spring-like approach:
 </p>
 <p>
 Methods in service-layer are annotated with <b>@ConsoleRequest</b> with value
 representing request pattern.
 </p>
 <p>
 Controller iterates all the services, checks their method for annotation,
 checks the regex-match for pattern and current request, and if it matches,
 invokes the service-method.
 </p>
 
 ## Service
 Services for <b>Department</b> and <b>Employee</b> entities related operations.
 <p>
 All the data, retrieved from the database,
 is processed to the specific <b>String</b>-format
 of the response, that is further passed to the view layer.
 </p>
 
 ## Entity
 Contains <b>Department</b> and <b>Employee</b> JPA-entities along with corresponding DTOs.
 
 ## Repository
 Repositories, containing operations, related to <b>Department</b> and <b>Employee</b> entities.
 
 ## Miscellaneous
 Unit-tests for <b>Repository</b> package.
 
