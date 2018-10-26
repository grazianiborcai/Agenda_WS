package br.com.gda.business.address.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class AddressSelect implements DaoStmtExec<AddressInfo> {
	private DaoStmtExec<AddressInfo> helper;
	
	
	public AddressSelect(List<DaoStmtExecOption<AddressInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AddressSelectSingle.class, AddressInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddressInfo> getResultset() {
		return helper.getResultset();
	}
}
