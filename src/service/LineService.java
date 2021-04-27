package service;


import domain.Line;

public interface LineService {
    void addOptionalLine(Line line);

    Line findSelectLineByLineId(String cid);

    void deleteServiceById(String cid);
}
