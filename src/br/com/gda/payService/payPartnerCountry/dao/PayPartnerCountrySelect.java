package br.com.gda.payService.payPartnerCountry.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payService.payPartnerCountry.info.PayPartnerCountryInfo;

public final class PayPartnerCountrySelect implements DaoStmtExec<PayPartnerCountryInfo> {
	private DaoStmtExec<PayPartnerCountryInfo> helper;
	
	
	public PayPartnerCountrySelect(List<DaoStmtExecOption<PayPartnerCountryInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayPartnerCountrySelectSingle.class, PayPartnerCountryInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayPartnerCountryInfo> getResultset() {
		return helper.getResultset();
	}
}
