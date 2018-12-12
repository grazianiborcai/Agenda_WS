package br.com.gda.business.addressSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class AddressSnapInsert implements DaoStmtExec<AddressSnapInfo> {
	private DaoStmtExec<AddressSnapInfo> helper;
	
	
	public AddressSnapInsert(List<DaoStmtExecOption<AddressSnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AddressSnapInsertSingle.class, AddressSnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddressSnapInfo> getResultset() {
		return helper.getResultset();
	}
}
