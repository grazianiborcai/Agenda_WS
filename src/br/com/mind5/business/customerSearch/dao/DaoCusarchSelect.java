package br.com.mind5.business.customerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoCusarchSelect implements DaoStmtExecV2<CusarchInfo> {
	private DaoStmtExecV2<CusarchInfo> helper;
	
	
	public DaoCusarchSelect(List<DaoStmtExecOption<CusarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCusarchSelectSingle.class, CusarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}
