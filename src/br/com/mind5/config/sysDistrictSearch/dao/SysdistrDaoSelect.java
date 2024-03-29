package br.com.mind5.config.sysDistrictSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.dao.DaoStmtExec;

public final class SysdistrDaoSelect implements DaoStmtExec<SysdistrInfo> {
	private DaoStmtExec<SysdistrInfo> helper;
	
	
	public SysdistrDaoSelect(List<DaoStmtExecOption<SysdistrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SysdistrDaoSelectSingle.class, SysdistrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysdistrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
