package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.dao.DaoStusorygeUpdate;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;

final class VisiStusorygeDaoUpdate extends ActionVisitorTemplateStmt<StusorygeInfo> {

	public VisiStusorygeDaoUpdate(DeciTreeOption<StusorygeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusorygeInfo> buildStmtExecHook(List<DaoStmtExecOption<StusorygeInfo>> stmtOptions) {
		return new DaoStusorygeUpdate(stmtOptions);
	}
}
