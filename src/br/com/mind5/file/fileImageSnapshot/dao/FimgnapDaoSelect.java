package br.com.mind5.file.fileImageSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;

public final class FimgnapDaoSelect implements DaoStmtExec<FimgnapInfo> {
	private DaoStmtExec<FimgnapInfo> helper;
	
	
	public FimgnapDaoSelect(List<DaoStmtExecOption<FimgnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FimgnapDaoSelectSingle.class, FimgnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FimgnapInfo> getResultset() {
		return helper.getResultset();
	}
	

	
	@Override public void close() {
		helper.close();		
	}
}
