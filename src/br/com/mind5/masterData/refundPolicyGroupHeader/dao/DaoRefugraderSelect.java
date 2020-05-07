package br.com.mind5.masterData.refundPolicyGroupHeader.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.refundPolicyGroupHeader.info.RefugraderInfo;

public final class DaoRefugraderSelect implements DaoStmtExecV2<RefugraderInfo> {
	private DaoStmtExecV2<RefugraderInfo> helper;
	
	
	public DaoRefugraderSelect(List<DaoStmtExecOption<RefugraderInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoRefugraderSelectSingle.class, RefugraderInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<RefugraderInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
