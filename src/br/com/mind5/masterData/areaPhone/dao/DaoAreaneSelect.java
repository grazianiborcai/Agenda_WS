package br.com.mind5.masterData.areaPhone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.areaPhone.info.AreaneInfo;

public final class DaoAreaneSelect implements DaoStmtExecV2<AreaneInfo> {
	private DaoStmtExecV2<AreaneInfo> helper;
	
	
	public DaoAreaneSelect(List<DaoStmtExecOption<AreaneInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoAreaneSelectSingle.class, AreaneInfo.class);
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
