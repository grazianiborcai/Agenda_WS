package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.planingData.dao.PlanataDaoSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanataVisiDaoSelect extends ActionVisitorTemplateStmt<PlanataInfo> {

	public PlanataVisiDaoSelect(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PlanataInfo> buildStmtExecHook(List<DaoStmtExecOption<PlanataInfo>> stmtOptions) {
		return new PlanataDaoSelect(stmtOptions);
	}
}
