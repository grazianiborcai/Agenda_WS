package br.com.mind5.payment.customerPartnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

public final class DaoCusparchSelect implements DaoStmtExecV2<CusparchInfo> {
	private DaoStmtExecV2<CusparchInfo> helper;
	
	
	public DaoCusparchSelect(List<DaoStmtExecOption<CusparchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCusparchSelectSingle.class, CusparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
