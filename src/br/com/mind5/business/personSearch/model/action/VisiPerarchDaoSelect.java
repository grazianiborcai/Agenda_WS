package br.com.mind5.business.personSearch.model.action;

import java.util.List;

import br.com.mind5.business.personSearch.dao.DaoPerarchSelect;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPerarchDaoSelect extends ActionVisitorTemplateStmtV2<PerarchInfo> {

	public VisiPerarchDaoSelect(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PerarchInfo> buildStmtExecHook(List<DaoStmtExecOption<PerarchInfo>> stmtOptions) {
		return new DaoPerarchSelect(stmtOptions);
	}
}