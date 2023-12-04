package com.group.inzynierka.domain;

import com.bastiaanjansen.otp.HMACAlgorithm;
import com.bastiaanjansen.otp.HOTPGenerator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class OtpGenerator {

    Random rand = new Random();

    byte[] secret = "VV3KOX7UQJ4ABCKOHMZPPH3US4CJZWG6F3ZKNB5C2OOBQHOQKIYHM27Q".getBytes();
    HOTPGenerator hotp = new HOTPGenerator.Builder(secret)
            .withPasswordLength(6)
            .withAlgorithm(HMACAlgorithm.SHA256)
            .build();

    public String generateCode(){
        int counter = rand.nextInt(1000000);
        return hotp.generate(counter);
    }

    public List<String> generateMoreCodes(){ //Generuje 500 kodów
        List<String> list = new ArrayList<>();
        for(int i = 0; i<500; i++){
            list.add(generateCode());
        }
        return list;
    }


}
