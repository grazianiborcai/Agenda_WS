package br.com.mind5.webhook.moipMultipayment.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class DaoWokaymoipSelect implements DaoStmtExecV2<WokaymoipInfo> {
	private DaoStmtExecV2<WokaymoipInfo> helper;
	
	
	public DaoWokaymoipSelect(List<DaoStmtExecOption<WokaymoipInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoWokaymoipSelectSingle.class, WokaymoipInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<WokaymoipInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}
