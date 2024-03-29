package br.com.mind5.masterData.materialSubgroup.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;

public final class MatubupDaoSelect implements DaoStmtExec<MatubupInfo> {
	private DaoStmtExec<MatubupInfo> helper;
	
	
	public MatubupDaoSelect(List<DaoStmtExecOption<MatubupInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatubupDaoSelectSingle.class, MatubupInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatubupInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
