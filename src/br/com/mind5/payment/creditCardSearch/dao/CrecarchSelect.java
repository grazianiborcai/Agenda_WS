package br.com.mind5.payment.creditCardSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

public final class CrecarchSelect implements DaoStmtExec_<CrecarchInfo> {
	private DaoStmtExec_<CrecarchInfo> helper;
	
	
	public CrecarchSelect(List<DaoStmtExecOption<CrecarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CrecarchSelectSingle.class, CrecarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CrecarchInfo> getResultset() {
		return helper.getResultset();
	}
}
