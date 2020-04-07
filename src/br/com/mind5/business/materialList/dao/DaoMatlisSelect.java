package br.com.mind5.business.materialList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMatlisSelect implements DaoStmtExecV2<MatlisInfo> {
	private DaoStmtExecV2<MatlisInfo> helper;
	
	
	public DaoMatlisSelect(List<DaoStmtExecOption<MatlisInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatlisSelectSingle.class, MatlisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatlisInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
