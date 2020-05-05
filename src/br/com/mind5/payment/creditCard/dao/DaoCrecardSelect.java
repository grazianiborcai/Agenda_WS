package br.com.mind5.payment.creditCard.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class DaoCrecardSelect implements DaoStmtExecV2<CrecardInfo> {
	private DaoStmtExecV2<CrecardInfo> helper;
	
	
	public DaoCrecardSelect(List<DaoStmtExecOption<CrecardInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCrecardSelectSingle.class, CrecardInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CrecardInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
