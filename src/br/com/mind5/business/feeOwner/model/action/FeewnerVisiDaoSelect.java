package br.com.mind5.business.feeOwner.model.action;

import java.util.List;

import br.com.mind5.business.feeOwner.dao.FeewnerDaoSelect;
import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeewnerVisiDaoSelect extends ActionVisitorTemplateStmt<FeewnerInfo> {

	public FeewnerVisiDaoSelect(DeciTreeOption<FeewnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FeewnerInfo> buildStmtExecHook(List<DaoStmtExecOption<FeewnerInfo>> stmtOptions) {
		return new FeewnerDaoSelect(stmtOptions);
	}
}
