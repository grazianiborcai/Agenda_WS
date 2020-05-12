package br.com.mind5.business.personList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoPersolisSelect implements DaoStmtExecV2<PersolisInfo> {
	private DaoStmtExecV2<PersolisInfo> helper;
	
	
	public DaoPersolisSelect(List<DaoStmtExecOption<PersolisInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPersolisSelectSingle.class, PersolisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PersolisInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();		
	}
}
