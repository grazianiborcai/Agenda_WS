package br.com.mind5.masterData.refundPolicyGroupSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;

public final class DaoRefugrarchSelect implements DaoStmtExecV2<RefugrarchInfo> {
	private DaoStmtExecV2<RefugrarchInfo> helper;
	
	
	public DaoRefugrarchSelect(List<DaoStmtExecOption<RefugrarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoRefugrarchSelectSingle.class, RefugrarchInfo.class);
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
