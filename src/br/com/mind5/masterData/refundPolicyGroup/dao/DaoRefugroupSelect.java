package br.com.mind5.masterData.refundPolicyGroup.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;

public final class DaoRefugroupSelect implements DaoStmtExec<RefugroupInfo> {
	private DaoStmtExec<RefugroupInfo> helper;
	
	
	public DaoRefugroupSelect(List<DaoStmtExecOption<RefugroupInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoRefugroupSelectSingle.class, RefugroupInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<RefugroupInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
