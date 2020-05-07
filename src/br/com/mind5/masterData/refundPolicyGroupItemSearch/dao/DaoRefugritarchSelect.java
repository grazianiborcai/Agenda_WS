package br.com.mind5.masterData.refundPolicyGroupItemSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;

public final class DaoRefugritarchSelect implements DaoStmtExecV2<RefugritarchInfo> {
	private DaoStmtExecV2<RefugritarchInfo> helper;
	
	
	public DaoRefugritarchSelect(List<DaoStmtExecOption<RefugritarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoRefugritarchSelectSingle.class, RefugritarchInfo.class);
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
