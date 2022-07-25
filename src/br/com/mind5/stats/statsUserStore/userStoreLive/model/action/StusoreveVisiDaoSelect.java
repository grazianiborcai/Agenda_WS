package br.com.mind5.stats.statsUserStore.userStoreLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreLive.dao.StusoreveDaoSelect;
import br.com.mind5.stats.statsUserStore.userStoreLive.info.StusoreveInfo;

public final class StusoreveVisiDaoSelect extends ActionVisitorTemplateStmt<StusoreveInfo> {

	public StusoreveVisiDaoSelect(DeciTreeOption<StusoreveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusoreveInfo> buildStmtExecHook(List<DaoStmtExecOption<StusoreveInfo>> stmtOptions) {
		return new StusoreveDaoSelect(stmtOptions);
	}
}
