package dao;

import domain.Line;

public interface LineDao {
    void addOptionalLine(Line l);

    Line findSelectLineByLineId(String cid);

    void deleteServiceById(String cid);
}
