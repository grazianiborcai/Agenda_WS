package br.com.mind5.payment.systemPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class DaoSysparSelect implements DaoStmtExecV2<SysparInfo> {
	private DaoStmtExecV2<SysparInfo> helper;
	
	
	public DaoSysparSelect(List<DaoStmtExecOption<SysparInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSysparSelectSingle.class, SysparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysparInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
