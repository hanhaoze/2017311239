package service;

import domain.Leader;
import domain.Line;
import domain.Operator;

import java.util.List;

public interface LeaderService {
    Leader login(Leader leader);

    List<Leader> findAll();

    List<Line> findMySelfOptionalLine(String T_id);

    void updateInfo(Leader leader);

    Leader findLeaderById(Leader leader);
}
