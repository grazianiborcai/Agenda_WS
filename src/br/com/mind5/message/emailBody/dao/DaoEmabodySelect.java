package br.com.mind5.message.emailBody.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class DaoEmabodySelect implements DaoStmtExecV2<EmabodyInfo> {
	private DaoStmtExecV2<EmabodyInfo> helper;
	
	
	public DaoEmabodySelect(List<DaoStmtExecOption<EmabodyInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmabodySelectSingle.class, EmabodyInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmabodyInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
