package br.com.mind5.payment.creditCard.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class DaoCrecardDelete implements DaoStmtExec<CrecardInfo> {
	private DaoStmtExec<CrecardInfo> helper;
	
	
	public DaoCrecardDelete(List<DaoStmtExecOption<CrecardInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCrecardDeleteSingle.class, CrecardInfo.class);
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
