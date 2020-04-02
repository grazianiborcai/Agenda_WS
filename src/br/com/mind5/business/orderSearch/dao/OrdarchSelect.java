package br.com.mind5.business.orderSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class OrdarchSelect implements DaoStmtExec_<OrdarchInfo> {
	private DaoStmtExec_<OrdarchInfo> helper;
	
	
	public OrdarchSelect(List<DaoStmtExecOption<OrdarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, OrdarchSelectSingle.class, OrdarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdarchInfo> getResultset() {
		return helper.getResultset();
	}
}
