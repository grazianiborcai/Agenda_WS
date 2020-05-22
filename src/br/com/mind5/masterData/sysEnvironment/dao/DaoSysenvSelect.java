package br.com.mind5.masterData.sysEnvironment.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

public final class DaoSysenvSelect implements DaoStmtExecV2<SysenvInfo> {
	private DaoStmtExecV2<SysenvInfo> helper;
	
	
	public DaoSysenvSelect(List<DaoStmtExecOption<SysenvInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSysenvSelectSingle.class, SysenvInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysenvInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
