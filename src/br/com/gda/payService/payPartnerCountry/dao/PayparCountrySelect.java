package br.com.gda.payService.payPartnerCountry.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payService.payPartnerCountry.info.PayparCountryInfo;

public final class PayparCountrySelect implements DaoStmtExec<PayparCountryInfo> {
	private DaoStmtExec<PayparCountryInfo> helper;
	
	
	public PayparCountrySelect(List<DaoStmtExecOption<PayparCountryInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayparCountrySelectSingle.class, PayparCountryInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayparCountryInfo> getResultset() {
		return helper.getResultset();
	}
}
