package br.com.mind5.masterData.countrySearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.countrySearch.dao.DaoCountarchSelect;
import br.com.mind5.masterData.countrySearch.info.CountarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCountarchDaoSelect extends ActionVisitorTemplateStmtV2<CountarchInfo> {

	public VisiCountarchDaoSelect(DeciTreeOption<CountarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CountarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CountarchInfo>> stmtOptions) {
		return new DaoCountarchSelect(stmtOptions);
	}
}
