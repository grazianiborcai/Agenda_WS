package br.com.mind5.masterData.refundPolicyGroup.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;

public final class DaoRefugroupSelect implements DaoStmtExecV2<RefugroupInfo> {
	private DaoStmtExecV2<RefugroupInfo> helper;
	
	
	public DaoRefugroupSelect(List<DaoStmtExecOption<RefugroupInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoRefugroupSelectSingle.class, RefugroupInfo.class);
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
