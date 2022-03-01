package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.dao.SowalagrDaoSelect;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;

public final class SowalagrVisiDaoSelect extends ActionVisitorTemplateStmt<SowalagrInfo> {

	public SowalagrVisiDaoSelect(DeciTreeOption<SowalagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowalagrInfo> buildStmtExecHook(List<DaoStmtExecOption<SowalagrInfo>> stmtOptions) {
		return new SowalagrDaoSelect(stmtOptions);
	}
}
