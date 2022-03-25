package br.com.mind5.business.employeeWorkTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class EmpwotmDaoDelete implements DaoStmtExec<EmpwotmInfo> {
	private DaoStmtExec<EmpwotmInfo> helper;
	
	
	public EmpwotmDaoDelete(List<DaoStmtExecOption<EmpwotmInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpwotmDaoDeleteSingle.class, EmpwotmInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpwotmInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
