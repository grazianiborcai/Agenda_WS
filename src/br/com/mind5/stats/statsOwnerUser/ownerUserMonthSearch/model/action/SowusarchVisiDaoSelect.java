package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.dao.SowusarchDaoSelect;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;

public final class SowusarchVisiDaoSelect extends ActionVisitorTemplateStmt<SowusarchInfo> {

	public SowusarchVisiDaoSelect(DeciTreeOption<SowusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowusarchInfo> buildStmtExecHook(List<DaoStmtExecOption<SowusarchInfo>> stmtOptions) {
		return new SowusarchDaoSelect(stmtOptions);
	}
}
