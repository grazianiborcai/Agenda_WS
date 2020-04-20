package br.com.mind5.business.companyList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoComplisSelect implements DaoStmtExecV2<ComplisInfo> {
	private DaoStmtExecV2<ComplisInfo> helper;
	
	
	public DaoComplisSelect(List<DaoStmtExecOption<ComplisInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoComplisSelectSingle.class, ComplisInfo.class);
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
