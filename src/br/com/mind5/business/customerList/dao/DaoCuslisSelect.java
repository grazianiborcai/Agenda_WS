package br.com.mind5.business.customerList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoCuslisSelect implements DaoStmtExecV2<CuslisInfo> {
	private DaoStmtExecV2<CuslisInfo> helper;
	
	
	public DaoCuslisSelect(List<DaoStmtExecOption<CuslisInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCuslisSelectSingle.class, CuslisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CuslisInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
