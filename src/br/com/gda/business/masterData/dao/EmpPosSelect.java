package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class EmpPosSelect implements DaoStmtExec<EmpPosInfo> {
	private DaoStmtExec<EmpPosInfo> helper;
	
	
	public EmpPosSelect(List<DaoStmtExecOption<EmpPosInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpPosSelectSingle.class, EmpPosInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpPosInfo> getResultset() {
		return helper.getResultset();
	}
}
