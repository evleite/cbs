package org.bb.cbs.restclient;

import org.bb.cbs.dto.EmployeeData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by newton on 1/21/17.
 */
public class EmployeeRestClient {

    private static RestTemplate restTemplate = new RestTemplate();

    public static List<EmployeeData> getEmployees(Integer employeeID, String empName) {

        String url = "http://localhost:8081/cbs-rest/rest/employee";

        // Query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("employeeID", employeeID)
                .queryParam("empName", empName);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(new HashMap());
        ResponseEntity<List<EmployeeData>> response = EmployeeRestClient.restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, request, new ParameterizedTypeReference<List<EmployeeData>>() {});
        return response.getBody();

    }

    public static EmployeeData updateEmployee(EmployeeData employee) {
        String url = "http://localhost:8081/cbs-rest/rest/employee";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<EmployeeData> request = new HttpEntity<>(employee);
        return EmployeeRestClient.restTemplate.postForObject(url, request, EmployeeData.class);
    }

    public static void deleteEmployee(Integer employeeID) {
        String url = "http://localhost:8081/cbs-rest/rest/employee/{employeeID}";

        // URI (URL) parameters
        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("employeeID", employeeID.toString());

        // URI builder
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        // Call http delete method
        EmployeeRestClient.restTemplate.delete(builder.buildAndExpand(uriParams).toUri());

    }

    public static void main(String[] args) {

        EmployeeData emp = new EmployeeData();
        emp.setEmployeeID(null);
        emp.setName("Test Name");
        emp.setEmail("test@email.com");
        EmployeeData empRes = EmployeeRestClient.updateEmployee(emp);
        System.out.println(empRes.toString());

        List<EmployeeData> result = EmployeeRestClient.getEmployees(empRes.getEmployeeID(), null);
        System.out.println(result.toString());

        EmployeeRestClient.deleteEmployee(result.get(0).getEmployeeID());

    }

}
