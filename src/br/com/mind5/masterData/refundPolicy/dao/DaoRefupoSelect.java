package br.com.mind5.masterData.refundPolicy.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;

public final class DaoRefupoSelect implements DaoStmtExec<RefupoInfo> {
	private DaoStmtExec<RefupoInfo> helper;
	
	
	public DaoRefupoSelect(List<DaoStmtExecOption<RefupoInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoRefupoSelectSingle.class, RefupoInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<RefupoInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
