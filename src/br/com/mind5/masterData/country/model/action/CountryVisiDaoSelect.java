package br.com.mind5.masterData.country.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.country.dao.CountryDaoSelect;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountryVisiDaoSelect extends ActionVisitorTemplateStmt<CountryInfo> {

	public CountryVisiDaoSelect(DeciTreeOption<CountryInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CountryInfo> buildStmtExecHook(List<DaoStmtExecOption<CountryInfo>> stmtOptions) {
		return new CountryDaoSelect(stmtOptions);
	}
}
