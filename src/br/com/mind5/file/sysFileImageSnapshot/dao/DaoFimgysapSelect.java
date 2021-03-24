package br.com.mind5.file.sysFileImageSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapInfo;

public final class DaoFimgysapSelect implements DaoStmtExec<FimgysapInfo> {
	private DaoStmtExec<FimgysapInfo> helper;
	
	
	public DaoFimgysapSelect(List<DaoStmtExecOption<FimgysapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoFimgysapSelectSingle.class, FimgysapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FimgysapInfo> getResultset() {
		return helper.getResultset();
	}
	

	
	@Override public void close() {
		helper.close();		
	}
}
