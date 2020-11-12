package br.com.mind5.business.feeDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoFeedefSelect implements DaoStmtExecV2<FeedefInfo> {
	private DaoStmtExecV2<FeedefInfo> helper;
	
	
	public DaoFeedefSelect(List<DaoStmtExecOption<FeedefInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoFeedefSelectSingle.class, FeedefInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeedefInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
