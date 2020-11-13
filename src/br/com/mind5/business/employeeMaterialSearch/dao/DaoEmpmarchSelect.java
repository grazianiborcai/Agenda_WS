package br.com.mind5.business.employeeMaterialSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoEmpmarchSelect implements DaoStmtExec<EmpmarchInfo> {
	private DaoStmtExec<EmpmarchInfo> helper;
	
	
	public DaoEmpmarchSelect(List<DaoStmtExecOption<EmpmarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoEmpmarchSelectSingle.class, EmpmarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpmarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
