package logAspect.service;

import logAspect.domain.model.Log;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
@Service
public class LogService {
    private Set<Log> db = new HashSet<>();
    public void save(Log log){
        db.add(log);
    }

    public Set<Log> getDb(){
        return db;
    }
}
