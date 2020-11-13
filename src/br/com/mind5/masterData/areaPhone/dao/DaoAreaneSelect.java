package br.com.mind5.masterData.areaPhone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.areaPhone.info.AreaneInfo;

public final class DaoAreaneSelect implements DaoStmtExec<AreaneInfo> {
	private DaoStmtExec<AreaneInfo> helper;
	
	
	public DaoAreaneSelect(List<DaoStmtExecOption<AreaneInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoAreaneSelectSingle.class, AreaneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AreaneInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
