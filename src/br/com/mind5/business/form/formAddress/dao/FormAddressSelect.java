package br.com.mind5.business.form.formAddress.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class FormAddressSelect implements DaoStmtExec<FormAddressInfo> {
	private DaoStmtExec<FormAddressInfo> helper;
	
	
	public FormAddressSelect(List<DaoStmtExecOption<FormAddressInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FormAddressSelectSingle.class, FormAddressInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FormAddressInfo> getResultset() {
		return helper.getResultset();
	}
}
