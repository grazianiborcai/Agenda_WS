package br.com.mind5.payment.countryPartnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

public final class DaoCounparchSelect implements DaoStmtExecV2<CounparchInfo> {
	private DaoStmtExecV2<CounparchInfo> helper;
	
	
	public DaoCounparchSelect(List<DaoStmtExecOption<CounparchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCounparchSelectSingle.class, CounparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CounparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
