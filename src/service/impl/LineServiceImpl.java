package service.impl;

import dao.LineDao;
import dao.impl.LineDaoImpl;
import domain.Line;
import service.LineService;

public class LineServiceImpl implements LineService {
    private LineDao dao = new LineDaoImpl();
    @Override
    public void addOptionalLine(Line line) {
        dao.addOptionalLine(line);

    }

    @Override
    public Line findSelectLineByLineId(String cid) {
        return dao.findSelectLineByLineId(cid);
    }

    @Override
    public void deleteServiceById(String cid) {
        dao.deleteServiceById(cid);

}
}
