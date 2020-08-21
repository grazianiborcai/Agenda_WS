package br.com.mind5.masterData.materialSubgroupSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;

public final class DaoMatubuparchSelect implements DaoStmtExecV2<MatubuparchInfo> {
	private DaoStmtExecV2<MatubuparchInfo> helper;
	
	
	public DaoMatubuparchSelect(List<DaoStmtExecOption<MatubuparchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatubuparchSelectSingle.class, MatubuparchInfo.class);
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
