package br.com.mind5.masterData.refundPolicyGroupHeaderSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.refundPolicyGroupHeaderSearch.info.RefugradarchInfo;

public final class DaoRefugradarchSelect implements DaoStmtExecV2<RefugradarchInfo> {
	private DaoStmtExecV2<RefugradarchInfo> helper;
	
	
	public DaoRefugradarchSelect(List<DaoStmtExecOption<RefugradarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoRefugradarchSelectSingle.class, RefugradarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<RefugradarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
