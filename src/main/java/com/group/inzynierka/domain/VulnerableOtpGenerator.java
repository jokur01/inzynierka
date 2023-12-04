package com.group.inzynierka.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class VulnerableOtpGenerator {

    public String generateVulnerableOTP() {
        // Generowanie trzech losowych cyfr na początku
        StringBuilder randomDigits = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int digit = random.nextInt(10);
            randomDigits.append(digit);
        }

        // Generowanie trzech stałych cyfr z puli
        String[] constantDigitsPool = {"123", "456", "789", "321", "654", "987", "876", "543", "210", "999"}; // Przykładowa pula kodów
        String constantDigits = constantDigitsPool[random.nextInt(constantDigitsPool.length)];

        // Łączenie losowych i stałych cyfr

        return randomDigits + constantDigits;
    }

    public List<String> generateMoreVulnerableOTP(){ //generuje 500 podatnych kodów
        List<String> list = new ArrayList<>();
        for(int i = 0; i<500; i++){
            list.add(generateVulnerableOTP());
        }
        return list;
    }
}
