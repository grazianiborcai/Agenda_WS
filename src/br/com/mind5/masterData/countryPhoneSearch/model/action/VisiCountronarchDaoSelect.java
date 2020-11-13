package br.com.mind5.masterData.countryPhoneSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.countryPhoneSearch.dao.DaoCountronarchSelect;
import br.com.mind5.masterData.countryPhoneSearch.info.CountronarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCountronarchDaoSelect extends ActionVisitorTemplateStmt<CountronarchInfo> {

	public VisiCountronarchDaoSelect(DeciTreeOption<CountronarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CountronarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CountronarchInfo>> stmtOptions) {
		return new DaoCountronarchSelect(stmtOptions);
	}
}
