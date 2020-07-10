package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.planingData.dao.DaoPlanataSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPlanataDaoSelect extends ActionVisitorTemplateStmtV2<PlanataInfo> {

	public VisiPlanataDaoSelect(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PlanataInfo> buildStmtExecHook(List<DaoStmtExecOption<PlanataInfo>> stmtOptions) {
		return new DaoPlanataSelect(stmtOptions);
	}
}
