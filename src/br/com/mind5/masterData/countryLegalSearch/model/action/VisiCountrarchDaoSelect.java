package br.com.mind5.masterData.countryLegalSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.countryLegalSearch.dao.DaoCountrarchSelect;
import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCountrarchDaoSelect extends ActionVisitorTemplateStmtV2<CountrarchInfo> {

	public VisiCountrarchDaoSelect(DeciTreeOption<CountrarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CountrarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CountrarchInfo>> stmtOptions) {
		return new DaoCountrarchSelect(stmtOptions);
	}
}
