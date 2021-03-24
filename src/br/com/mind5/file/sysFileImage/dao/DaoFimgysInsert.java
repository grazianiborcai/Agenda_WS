package br.com.mind5.file.sysFileImage.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoFimgysInsert implements DaoStmtExec<FimgysInfo> {
	private DaoStmtExec<FimgysInfo> helper;
	
	
	public DaoFimgysInsert(List<DaoStmtExecOption<FimgysInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoFimgysInsertSingle.class, FimgysInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FimgysInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();		
	}
}
