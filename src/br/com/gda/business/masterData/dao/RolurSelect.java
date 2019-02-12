package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.RolurInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public class RolurSelect implements DaoStmtExec<RolurInfo> {
	private DaoStmtExec<RolurInfo> helper;
	
	
	public RolurSelect(List<DaoStmtExecOption<RolurInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, RolurSelectSingle.class, RolurInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<RolurInfo> getResultset() {
		return helper.getResultset();
	}
}
