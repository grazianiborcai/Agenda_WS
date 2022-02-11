package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.dao.DaoSowaliveSelect;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;

final class VisiSowordiveDaoSelect extends ActionVisitorTemplateStmt<SowaliveInfo> {

	public VisiSowordiveDaoSelect(DeciTreeOption<SowaliveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowaliveInfo> buildStmtExecHook(List<DaoStmtExecOption<SowaliveInfo>> stmtOptions) {
		return new DaoSowaliveSelect(stmtOptions);
	}
}
