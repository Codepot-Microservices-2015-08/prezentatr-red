package pl.codepot.prezentatr

import org.springframework.stereotype.Service
import com.ofg.infrastructure.correlationid.CorrelationIdHolder;

@Service
class ProcessService {

    Set<String> dojrzewanie = new HashSet<>()
    Set<String> butelkowanie = new HashSet<>()
    Set<String> butelki =  new HashSet<>()


    void addDojrzewatr() {
        dojrzewanie.add(CorrelationIdHolder.get())
    }

    void addButelkatr() {
        dojrzewanie.remove(CorrelationIdHolder.get())
        butelkowanie.add(CorrelationIdHolder.get())
    }

     void addButelka() {
         butelkowanie.remove(CorrelationIdHolder.get())
         butelki.add(CorrelationIdHolder.get())
     }


    Long getDojrzewatrCount() {
        return dojrzewanie.size()
    }

    Long getButelkowanieCount() {
         return butelkowanie.size()
    }

    Long getButelkiCount() {
        return butelki.size()
    }



}
