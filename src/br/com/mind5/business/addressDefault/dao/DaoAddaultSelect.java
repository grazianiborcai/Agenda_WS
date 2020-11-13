package br.com.mind5.business.addressDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoAddaultSelect implements DaoStmtExec<AddaultInfo> {
	private DaoStmtExec<AddaultInfo> helper;
	
	
	public DaoAddaultSelect(List<DaoStmtExecOption<AddaultInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoAddaultSelectSingle.class, AddaultInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddaultInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
