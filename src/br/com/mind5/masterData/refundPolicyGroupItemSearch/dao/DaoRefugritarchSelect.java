package br.com.mind5.masterData.refundPolicyGroupItemSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;

public final class DaoRefugritarchSelect implements DaoStmtExec<RefugritarchInfo> {
	private DaoStmtExec<RefugritarchInfo> helper;
	
	
	public DaoRefugritarchSelect(List<DaoStmtExecOption<RefugritarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoRefugritarchSelectSingle.class, RefugritarchInfo.class);
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
