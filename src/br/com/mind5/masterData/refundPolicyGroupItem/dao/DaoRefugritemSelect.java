package br.com.mind5.masterData.refundPolicyGroupItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;

public final class DaoRefugritemSelect implements DaoStmtExecV2<RefugritemInfo> {
	private DaoStmtExecV2<RefugritemInfo> helper;
	
	
	public DaoRefugritemSelect(List<DaoStmtExecOption<RefugritemInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoRefugritemSelectSingle.class, RefugritemInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<RefugritemInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
