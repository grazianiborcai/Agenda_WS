package br.com.mind5.business.form.formAddress.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class FormAddressSelect implements DaoStmtExec_<FormAddressInfo> {
	private DaoStmtExec_<FormAddressInfo> helper;
	
	
	public FormAddressSelect(List<DaoStmtExecOption<FormAddressInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, FormAddressSelectSingle.class, FormAddressInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FormAddressInfo> getResultset() {
		return helper.getResultset();
	}
}
