package br.com.mind5.masterData.refundPolicyGroupItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;

public final class RefugritemDaoSelect implements DaoStmtExec<RefugritemInfo> {
	private DaoStmtExec<RefugritemInfo> helper;
	
	
	public RefugritemDaoSelect(List<DaoStmtExecOption<RefugritemInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, RefugritemDaoSelectSingle.class, RefugritemInfo.class);
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
