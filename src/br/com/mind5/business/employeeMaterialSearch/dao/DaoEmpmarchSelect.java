package br.com.mind5.business.employeeMaterialSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmpmarchSelect implements DaoStmtExecV2<EmpmarchInfo> {
	private DaoStmtExecV2<EmpmarchInfo> helper;
	
	
	public DaoEmpmarchSelect(List<DaoStmtExecOption<EmpmarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmpmarchSelectSingle.class, EmpmarchInfo.class);
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
