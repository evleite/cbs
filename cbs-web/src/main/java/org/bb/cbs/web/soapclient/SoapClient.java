package org.bb.cbs.web.soapclient;

import org.bb.cbs.soap.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

/**
 * Created by newton on 1/7/17.
 */
public class SoapClient extends WebServiceGatewaySupport {

    public ListEmployeesResponse getEmployees() {
        ObjectFactory factory = new ObjectFactory();
        ListEmployees request = new ListEmployees();
        JAXBElement<ListEmployeesResponse> jaxbResponse = (JAXBElement<ListEmployeesResponse>) this.getWebServiceTemplate().marshalSendAndReceive(factory.createListEmployees(request));
        return jaxbResponse.getValue();
    }

    public EmployeeData updateEmployee(EmployeeData employee) {
        ObjectFactory factory = new ObjectFactory();
        UpdateEmployee request = new UpdateEmployee();
        request.setArg0(employee);
        JAXBElement<UpdateEmployeeResponse> jaxbResponse = (JAXBElement<UpdateEmployeeResponse>) this.getWebServiceTemplate().marshalSendAndReceive(factory.createUpdateEmployee(request));
        return jaxbResponse.getValue().getReturn();
    }

}
