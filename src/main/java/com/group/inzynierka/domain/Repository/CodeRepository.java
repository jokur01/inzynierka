package com.group.inzynierka.domain.Repository;

import com.group.inzynierka.domain.Entity.OtpCode;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodeRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addCodes(List<String> ListOfCodes) {
        for (int i = 0; i < ListOfCodes.size(); i++) {
            em.persist(new OtpCode(ListOfCodes.get(i)));
            if (i % 20 == 0) {
                em.flush();
                em.clear();
            }
        }
    }

    public List<OtpCode> getCodes(){
        return em.createQuery("from OtpCode", OtpCode.class).getResultList();
    }

    public void printCodes(List<OtpCode> list){
        if(list.isEmpty()){
            System.out.println("Pusta lista");
        }
        else{
            for (OtpCode otpCode : list) {
                System.out.println(otpCode.getCode());
            }
        }
    }

    @Transactional
    public void deleteAllCodes(){
        List<OtpCode> list = getCodes();
        for(int i = 0; i<list.size(); i++){
            em.remove(em.contains(list.get(i)) ? list.get(i) : em.merge(list.get(i)));

            if(i%3==0){
                em.flush();
                em.clear();
            }
        }
    }
}
