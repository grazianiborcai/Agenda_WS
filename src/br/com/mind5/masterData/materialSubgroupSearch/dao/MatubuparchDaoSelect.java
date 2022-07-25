package br.com.mind5.masterData.materialSubgroupSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;

public final class MatubuparchDaoSelect implements DaoStmtExec<MatubuparchInfo> {
	private DaoStmtExec<MatubuparchInfo> helper;
	
	
	public MatubuparchDaoSelect(List<DaoStmtExecOption<MatubuparchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatubuparchDaoSelectSingle.class, MatubuparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatubuparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
