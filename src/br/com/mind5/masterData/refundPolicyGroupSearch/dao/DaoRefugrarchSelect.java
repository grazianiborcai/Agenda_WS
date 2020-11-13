package br.com.mind5.masterData.refundPolicyGroupSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;

public final class DaoRefugrarchSelect implements DaoStmtExec<RefugrarchInfo> {
	private DaoStmtExec<RefugrarchInfo> helper;
	
	
	public DaoRefugrarchSelect(List<DaoStmtExecOption<RefugrarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoRefugrarchSelectSingle.class, RefugrarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<RefugrarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
