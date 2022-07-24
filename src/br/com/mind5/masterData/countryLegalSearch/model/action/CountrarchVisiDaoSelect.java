package br.com.mind5.masterData.countryLegalSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.countryLegalSearch.dao.CountrarchDaoSelect;
import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountrarchVisiDaoSelect extends ActionVisitorTemplateStmt<CountrarchInfo> {

	public CountrarchVisiDaoSelect(DeciTreeOption<CountrarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CountrarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CountrarchInfo>> stmtOptions) {
		return new CountrarchDaoSelect(stmtOptions);
	}
}
