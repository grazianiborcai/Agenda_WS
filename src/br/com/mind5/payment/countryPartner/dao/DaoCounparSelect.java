package br.com.mind5.payment.countryPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class DaoCounparSelect implements DaoStmtExecV2<CounparInfo> {
	private DaoStmtExecV2<CounparInfo> helper;
	
	
	public DaoCounparSelect(List<DaoStmtExecOption<CounparInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCounparSelectSingle.class, CounparInfo.class);
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
