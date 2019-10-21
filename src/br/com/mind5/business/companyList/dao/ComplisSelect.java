package br.com.mind5.business.companyList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class ComplisSelect implements DaoStmtExec<ComplisInfo> {
	private DaoStmtExec<ComplisInfo> helper;
	
	
	public ComplisSelect(List<DaoStmtExecOption<ComplisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, ComplisSelectSingle.class, ComplisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<ComplisInfo> getResultset() {
		return helper.getResultset();
	}
}
