package br.com.mind5.payment.countryPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class DaoCounparSelect implements DaoStmtExec<CounparInfo> {
	private DaoStmtExec<CounparInfo> helper;
	
	
	public DaoCounparSelect(List<DaoStmtExecOption<CounparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCounparSelectSingle.class, CounparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CounparInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
