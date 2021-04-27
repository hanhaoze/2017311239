package dao;

import domain.Leader;
import domain.Line;

import java.util.List;

public interface LeaderDao {
        Leader findLeaderidAndPassword(String id, String password);

         List<Leader> findAll();

         List<Line> findMySelfOptionalLine(String t_id);

         void updateInfo(Leader leader);

         Leader findLeaderById(String t_id);


}
