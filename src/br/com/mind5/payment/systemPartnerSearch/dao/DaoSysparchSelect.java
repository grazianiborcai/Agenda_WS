package br.com.mind5.payment.systemPartnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;

public final class DaoSysparchSelect implements DaoStmtExecV2<SysparchInfo> {
	private DaoStmtExecV2<SysparchInfo> helper;
	
	
	public DaoSysparchSelect(List<DaoStmtExecOption<SysparchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSysparchSelectSingle.class, SysparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
