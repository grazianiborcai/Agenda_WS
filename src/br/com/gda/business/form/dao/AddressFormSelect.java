package br.com.gda.business.form.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class AddressFormSelect implements DaoStmtExec<AddressFormInfo> {
	private DaoStmtExec<AddressFormInfo> helper;
	
	
	public AddressFormSelect(List<DaoStmtExecOption<AddressFormInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AddressFormSelectSingle.class, AddressFormInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddressFormInfo> getResultset() {
		return helper.getResultset();
	}
}
