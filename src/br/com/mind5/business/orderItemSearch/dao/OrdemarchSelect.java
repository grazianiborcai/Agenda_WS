package br.com.mind5.business.orderItemSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class OrdemarchSelect implements DaoStmtExec_<OrdemarchInfo> {
	private DaoStmtExec_<OrdemarchInfo> helper;
	
	
	public OrdemarchSelect(List<DaoStmtExecOption<OrdemarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, OrdemarchSelectSingle.class, OrdemarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdemarchInfo> getResultset() {
		return helper.getResultset();
	}
}
