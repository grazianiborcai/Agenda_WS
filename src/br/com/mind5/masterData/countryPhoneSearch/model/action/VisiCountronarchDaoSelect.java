package br.com.mind5.masterData.countryPhoneSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.countryPhoneSearch.dao.DaoCountronarchSelect;
import br.com.mind5.masterData.countryPhoneSearch.info.CountronarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCountronarchDaoSelect extends ActionVisitorTemplateStmtV2<CountronarchInfo> {

	public VisiCountronarchDaoSelect(DeciTreeOption<CountronarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CountronarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CountronarchInfo>> stmtOptions) {
		return new DaoCountronarchSelect(stmtOptions);
	}
}
