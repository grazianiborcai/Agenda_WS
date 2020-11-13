package br.com.mind5.business.storeWorkTimeRange.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTimeRange.dao.DaoStoworgSelect;
import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoworgDaoSelect extends ActionVisitorTemplateStmtV2<StoworgInfo> {

	public VisiStoworgDaoSelect(DeciTreeOption<StoworgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StoworgInfo> buildStmtExecHook(List<DaoStmtExecOption<StoworgInfo>> stmtOptions) {
		return new DaoStoworgSelect(stmtOptions);
	}
}
