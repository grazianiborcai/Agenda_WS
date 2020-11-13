package br.com.mind5.masterData.countryPhone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;

public final class DaoCountroneSelect implements DaoStmtExec<CountroneInfo> {
	private DaoStmtExec<CountroneInfo> helper;
	
	
	public DaoCountroneSelect(List<DaoStmtExecOption<CountroneInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCountroneSelectSingle.class, CountroneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CountroneInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
