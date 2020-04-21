package br.com.mind5.masterData.businessAreaSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;

public final class DaoBusarearchSelect implements DaoStmtExecV2<BusarearchInfo> {
	private DaoStmtExecV2<BusarearchInfo> helper;
	
	
	public DaoBusarearchSelect(List<DaoStmtExecOption<BusarearchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoBusarearchSelectSingle.class, BusarearchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BusarearchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
