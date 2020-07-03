package br.com.mind5.business.customerSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoCusnapSelect implements DaoStmtExecV2<CusnapInfo> {
	private DaoStmtExecV2<CusnapInfo> helper;
	
	
	public DaoCusnapSelect(List<DaoStmtExecOption<CusnapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCusnapSelectSingle.class, CusnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
