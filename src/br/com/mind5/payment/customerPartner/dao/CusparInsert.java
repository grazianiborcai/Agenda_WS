package br.com.mind5.payment.customerPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparInsert implements DaoStmtExec_<CusparInfo> {
	private DaoStmtExec_<CusparInfo> helper;
	
	
	public CusparInsert(List<DaoStmtExecOption<CusparInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CusparInsertSingle.class, CusparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<CusparInfo> getResultset() {
		return helper.getResultset();
	}
}
