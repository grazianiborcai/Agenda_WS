package br.com.mind5.masterData.refundPolicyGroupItemSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;

public final class RefugritarchDaoSelect implements DaoStmtExec<RefugritarchInfo> {
	private DaoStmtExec<RefugritarchInfo> helper;
	
	
	public RefugritarchDaoSelect(List<DaoStmtExecOption<RefugritarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, RefugritarchDaoSelectSingle.class, RefugritarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<RefugritarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
