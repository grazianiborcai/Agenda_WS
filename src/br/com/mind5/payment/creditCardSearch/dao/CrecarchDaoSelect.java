package br.com.mind5.payment.creditCardSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

public final class CrecarchDaoSelect implements DaoStmtExec<CrecarchInfo> {
	private DaoStmtExec<CrecarchInfo> helper;
	
	
	public CrecarchDaoSelect(List<DaoStmtExecOption<CrecarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CrecarchDaoSelectSingle.class, CrecarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CrecarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
