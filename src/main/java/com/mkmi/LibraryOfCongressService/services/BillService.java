package com.mkmi.LibraryOfCongressService.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpServerErrorException;

import com.mkmi.LibraryOfCongressService.models.Bill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BillService {

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    @Value("${congress.api.key}") // Inject your API key from application.properties
    private String apiKey;

    private final String apiUrl = "https://api.congress.gov/v3/bill";

    private final RestTemplate restTemplate;

    public BillService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Retrieve and return a list of bills
    public List<Bill> getAllBills() {
        try {
            String url = apiUrl + "?api_key=" + apiKey;
            Bill[] bills = restTemplate.getForObject(url, Bill[].class);
            return bills != null ? Arrays.asList(bills) : new ArrayList<>();
        } catch (HttpServerErrorException e) {
            logger.error("Error while fetching bills from API: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logDeserializationError(e);
            throw e;
        }
    }

    // Retrieve and return bills filtered by congress
    public List<Bill> getBillsByCongress(String congress) {
        try {
            String url = apiUrl + "?api_key=" + apiKey + "&congress=" + congress;
            Bill[] bills = restTemplate.getForObject(url, Bill[].class);
            return bills != null ? Arrays.asList(bills) : new ArrayList<>();
        } catch (HttpServerErrorException e) {
            logger.error("Error while fetching bills from API: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logDeserializationError(e);
            throw e;
        }
    }

    // Retrieve and return bills filtered by congress and bill type
    public List<Bill> getBillsByCongressAndType(String congress, String billType) {
        try {
            String url = apiUrl + "?api_key=" + apiKey + "&congress=" + congress + "&billType=" + billType;
            Bill[] bills = restTemplate.getForObject(url, Bill[].class);
            return bills != null ? Arrays.asList(bills) : new ArrayList<>();
        } catch (HttpServerErrorException e) {
            logger.error("Error while fetching bills from API: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logDeserializationError(e);
            throw e;
        }
    }

    // Retrieve and return bill details by congress, bill type, and bill number
    public Bill getBillDetails(String congress, String billType, String billNumber) {
        try {
            String url = apiUrl + "/" + congress + "/" + billType + "/" + billNumber + "?api_key=" + apiKey;
            return restTemplate.getForObject(url, Bill.class);
        } catch (HttpServerErrorException e) {
            logger.error("Error while fetching bill details from API: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logDeserializationError(e);
            throw e;
        }
    }

    // Additional methods for error handling and logging

    private void logApiResponse(String apiResponse) {
        logger.debug("API Response: " + apiResponse);
    }

    private void logDeserializationError(Exception e) {
        logger.error("Error during deserialization: " + e.getMessage(), e);
    }
}
