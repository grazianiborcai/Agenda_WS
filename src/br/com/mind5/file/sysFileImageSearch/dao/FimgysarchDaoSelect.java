package br.com.mind5.file.sysFileImageSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;

public final class FimgysarchDaoSelect implements DaoStmtExec<FimgysarchInfo> {
	private DaoStmtExec<FimgysarchInfo> helper;
	
	
	public FimgysarchDaoSelect(List<DaoStmtExecOption<FimgysarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FimgysarchDaoSelectSingle.class, FimgysarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FimgysarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
