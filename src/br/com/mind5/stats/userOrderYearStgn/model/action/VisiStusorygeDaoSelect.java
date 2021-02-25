package br.com.mind5.stats.userOrderYearStgn.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userOrderYearStgn.dao.DaoStusorygeSelect;
import br.com.mind5.stats.userOrderYearStgn.info.StusorygeInfo;

final class VisiStusorygeDaoSelect extends ActionVisitorTemplateStmt<StusorygeInfo> {

	public VisiStusorygeDaoSelect(DeciTreeOption<StusorygeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusorygeInfo> buildStmtExecHook(List<DaoStmtExecOption<StusorygeInfo>> stmtOptions) {
		return new DaoStusorygeSelect(stmtOptions);
	}
}
