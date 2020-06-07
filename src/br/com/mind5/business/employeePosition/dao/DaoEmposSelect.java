package br.com.mind5.business.employeePosition.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public class DaoEmposSelect implements DaoStmtExecV2<EmposInfo> {
	private DaoStmtExecV2<EmposInfo> helper;
	
	
	public DaoEmposSelect(List<DaoStmtExecOption<EmposInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmposSelectSingle.class, EmposInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmposInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
