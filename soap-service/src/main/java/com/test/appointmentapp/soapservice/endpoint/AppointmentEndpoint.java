package com.test.appointmentapp.soapservice.endpoint;

import com.test.appointmentapp.soapservice.exception.ValidationException;
import com.test.appointmentapp.soapservice.service.AppointmentService;
import com.test.appointmentapp.soapservice.xml.AppointmentRequest;
import com.test.appointmentapp.soapservice.xml.AppointmentResponse;
import jakarta.websocket.MessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class AppointmentEndpoint implements MessageHandler {
    private static final String NAMESPACE_URI = "http://www.test.com/appointmentapp/soapservice/xml";
    private final AppointmentService appointmentService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AppointmentRequest")
    @ResponsePayload
    public AppointmentResponse getAppointmentResponse(@RequestPayload AppointmentRequest request)
    {
        if (request.getDuration() <= 0 || request.getCount() <= 0) {
            throw new ValidationException("Incorrect request!");
        }
        appointmentService.addAppointment(request);
        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setStatus("OK");
        return appointmentResponse;
    }
}

// Example of Request

/*
URL: http://localhost:8082/soap-api/ws/

<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <tns:AppointmentRequest xmlns:tns="http://www.test.com/appointmentapp/soapservice/xml">
      <tns:doctorId>1</tns:doctorId>
      <tns:startTime>2023-09-20T10:00:00</tns:startTime>
      <tns:duration>30</tns:duration>
      <tns:count>10</tns:count>
    </tns:AppointmentRequest>
  </soap:Body>
</soap:Envelope>

 */