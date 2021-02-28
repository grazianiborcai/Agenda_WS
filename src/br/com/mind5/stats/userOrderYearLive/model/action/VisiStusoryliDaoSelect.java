package br.com.mind5.stats.userOrderYearLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userOrderYearLive.dao.DaoStusoryliSelect;
import br.com.mind5.stats.userOrderYearLive.info.StusoryliInfo;

final class VisiStusoryliDaoSelect extends ActionVisitorTemplateStmt<StusoryliInfo> {

	public VisiStusoryliDaoSelect(DeciTreeOption<StusoryliInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusoryliInfo> buildStmtExecHook(List<DaoStmtExecOption<StusoryliInfo>> stmtOptions) {
		return new DaoStusoryliSelect(stmtOptions);
	}
}
