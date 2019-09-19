package br.com.gda.business.addressSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.addressSearch.info.AddarchInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class AddarchSelect implements DaoStmtExec<AddarchInfo> {
	private DaoStmtExec<AddarchInfo> helper;
	
	
	public AddarchSelect(List<DaoStmtExecOption<AddarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AddarchSelectSingle.class, AddarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddarchInfo> getResultset() {
		return helper.getResultset();
	}
}
