package br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.dao.StusoryliDaoSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.info.StusoryliInfo;

public final class StusoryliVisiDaoSelect extends ActionVisitorTemplateStmt<StusoryliInfo> {

	public StusoryliVisiDaoSelect(DeciTreeOption<StusoryliInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusoryliInfo> buildStmtExecHook(List<DaoStmtExecOption<StusoryliInfo>> stmtOptions) {
		return new StusoryliDaoSelect(stmtOptions);
	}
}
