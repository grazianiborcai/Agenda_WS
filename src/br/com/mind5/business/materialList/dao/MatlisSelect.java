package br.com.mind5.business.materialList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MatlisSelect implements DaoStmtExec<MatlisInfo> {
	private DaoStmtExec<MatlisInfo> helper;
	
	
	public MatlisSelect(List<DaoStmtExecOption<MatlisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatlisSelectSingle.class, MatlisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatlisInfo> getResultset() {
		return helper.getResultset();
	}
}
