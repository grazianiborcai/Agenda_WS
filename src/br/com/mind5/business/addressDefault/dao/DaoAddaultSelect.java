package br.com.mind5.business.addressDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoAddaultSelect implements DaoStmtExecV2<AddaultInfo> {
	private DaoStmtExecV2<AddaultInfo> helper;
	
	
	public DaoAddaultSelect(List<DaoStmtExecOption<AddaultInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoAddaultSelectSingle.class, AddaultInfo.class);
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
