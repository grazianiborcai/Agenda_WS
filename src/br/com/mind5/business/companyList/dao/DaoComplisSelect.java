package br.com.mind5.business.companyList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoComplisSelect implements DaoStmtExec<ComplisInfo> {
	private DaoStmtExec<ComplisInfo> helper;
	
	
	public DaoComplisSelect(List<DaoStmtExecOption<ComplisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoComplisSelectSingle.class, ComplisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<ComplisInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
