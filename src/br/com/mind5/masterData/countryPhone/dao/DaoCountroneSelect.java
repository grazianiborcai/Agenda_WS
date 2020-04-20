package br.com.mind5.masterData.countryPhone.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;

public final class DaoCountroneSelect implements DaoStmtExecV2<CountroneInfo> {
	private DaoStmtExecV2<CountroneInfo> helper;
	
	
	public DaoCountroneSelect(List<DaoStmtExecOption<CountroneInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCountroneSelectSingle.class, CountroneInfo.class);
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
