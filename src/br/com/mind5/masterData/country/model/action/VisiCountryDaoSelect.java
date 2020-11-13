package br.com.mind5.masterData.country.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.country.dao.DaoCountrySelect;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCountryDaoSelect extends ActionVisitorTemplateStmt<CountryInfo> {

	public VisiCountryDaoSelect(DeciTreeOption<CountryInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CountryInfo> buildStmtExecHook(List<DaoStmtExecOption<CountryInfo>> stmtOptions) {
		return new DaoCountrySelect(stmtOptions);
	}
}
