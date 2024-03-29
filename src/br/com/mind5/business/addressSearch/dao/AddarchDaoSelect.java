package br.com.mind5.business.addressSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class AddarchDaoSelect implements DaoStmtExec<AddarchInfo> {
	private DaoStmtExec<AddarchInfo> helper;
	
	
	public AddarchDaoSelect(List<DaoStmtExecOption<AddarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AddarchDaoSelectSingle.class, AddarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
