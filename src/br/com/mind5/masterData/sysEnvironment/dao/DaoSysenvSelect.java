package br.com.mind5.masterData.sysEnvironment.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

public final class DaoSysenvSelect implements DaoStmtExec<SysenvInfo> {
	private DaoStmtExec<SysenvInfo> helper;
	
	
	public DaoSysenvSelect(List<DaoStmtExecOption<SysenvInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSysenvSelectSingle.class, SysenvInfo.class);
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
