package br.com.mind5.payment.customerPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class DaoCusparInsert implements DaoStmtExecV2<CusparInfo> {
	private DaoStmtExecV2<CusparInfo> helper;
	
	
	public DaoCusparInsert(List<DaoStmtExecOption<CusparInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCusparInsertSingle.class, CusparInfo.class);
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
