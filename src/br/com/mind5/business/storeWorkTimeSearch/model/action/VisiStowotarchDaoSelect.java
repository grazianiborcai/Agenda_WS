package br.com.mind5.business.storeWorkTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.dao.DaoStowotarchSelect;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStowotarchDaoSelect extends ActionVisitorTemplateStmtV2<StowotarchInfo> {

	public VisiStowotarchDaoSelect(DeciTreeOption<StowotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StowotarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StowotarchInfo>> stmtOptions) {
		return new DaoStowotarchSelect(stmtOptions);
	}
}
