package br.com.mind5.payment.customerPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class DaoCusparSelect implements DaoStmtExec<CusparInfo> {
	private DaoStmtExec<CusparInfo> helper;
	
	
	public DaoCusparSelect(List<DaoStmtExecOption<CusparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCusparSelectSingle.class, CusparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusparInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
