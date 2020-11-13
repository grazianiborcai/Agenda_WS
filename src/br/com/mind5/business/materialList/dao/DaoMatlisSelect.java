package br.com.mind5.business.materialList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoMatlisSelect implements DaoStmtExec<MatlisInfo> {
	private DaoStmtExec<MatlisInfo> helper;
	
	
	public DaoMatlisSelect(List<DaoStmtExecOption<MatlisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMatlisSelectSingle.class, MatlisInfo.class);
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
