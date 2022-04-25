package br.com.mind5.business.employeeLunchTimeConflict.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulocoInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class EmpulocoDaoSelect implements DaoStmtExec<EmpulocoInfo> {
	private DaoStmtExec<EmpulocoInfo> helper;
	
	
	public EmpulocoDaoSelect(List<DaoStmtExecOption<EmpulocoInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpulocoDaoSelectSingle.class, EmpulocoInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpulocoInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
