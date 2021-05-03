package service.impl;

import dao.LeaderDao;
import dao.impl.LeaderDaoImpl;
import domain.Leader;
import domain.Line;
import service.LeaderService;

import java.util.List;

public class LeaderServiceImpl implements LeaderService {
    private LeaderDao dao = new LeaderDaoImpl();

    @Override
    public Leader login(Leader leader) {
        return dao.findLeaderidAndPassword(leader.getT_id(),leader.getT_password());
    }

    @Override
    public List<Leader> findAll() {
        return dao.findAll();
    }

    @Override
    public void updateInfo(Leader leader) {
        dao.updateInfo(leader);
    }

    @Override
    public Leader findLeaderById(Leader leader) {
        return dao.findLeaderById(leader.getT_id());
    }

    @Override
    public List<Line> findMySelfOptionalLine(String T_id) {
        return dao.findMySelfOptionalLine(T_id);
    }

    @Override
    public void updatePassword(String leaderid, String newpassword) {
        dao.updatePassword(leaderid,newpassword);
    }

    @Override
    public void addLeaderAllInfo(Leader updateLeader) {dao.addLeaderAllInfo(updateLeader);

    }
}

