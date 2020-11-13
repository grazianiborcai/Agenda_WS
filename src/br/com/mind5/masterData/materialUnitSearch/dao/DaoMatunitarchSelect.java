package br.com.mind5.masterData.materialUnitSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialUnitSearch.info.MatunitarchInfo;

public final class DaoMatunitarchSelect implements DaoStmtExec<MatunitarchInfo> {
	private DaoStmtExec<MatunitarchInfo> helper;
	
	
	public DaoMatunitarchSelect(List<DaoStmtExecOption<MatunitarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMatunitarchSelectSingle.class, MatunitarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatunitarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
