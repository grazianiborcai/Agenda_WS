package br.com.mind5.business.employeeWorkTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmpwotmInsert implements DaoStmtExecV2<EmpwotmInfo> {	
	private DaoStmtExecV2<EmpwotmInfo> helper;
	
	
	public DaoEmpwotmInsert(List<DaoStmtExecOption<EmpwotmInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmpwotmInsertSingle.class, EmpwotmInfo.class);
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