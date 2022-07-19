package br.com.mind5.payment.countryPartnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

public final class CounparchDaoSelect implements DaoStmtExec<CounparchInfo> {
	private DaoStmtExec<CounparchInfo> helper;
	
	
	public CounparchDaoSelect(List<DaoStmtExecOption<CounparchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CounparchDaoSelectSingle.class, CounparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CounparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
