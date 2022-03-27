package br.com.mind5.business.employeeWorkTimeSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class EmpwotmapDaoSelect implements DaoStmtExec<EmpwotmapInfo> {
	private DaoStmtExec<EmpwotmapInfo> helper;
	
	
	public EmpwotmapDaoSelect(List<DaoStmtExecOption<EmpwotmapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpwotmapDaoSelectSingle.class, EmpwotmapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpwotmapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
