package br.com.mind5.business.feeOwner.model.action;

import java.util.List;

import br.com.mind5.business.feeOwner.dao.DaoFeewnerSelect;
import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFeewnerDaoSelect extends ActionVisitorTemplateStmt<FeewnerInfo> {

	public VisiFeewnerDaoSelect(DeciTreeOption<FeewnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FeewnerInfo> buildStmtExecHook(List<DaoStmtExecOption<FeewnerInfo>> stmtOptions) {
		return new DaoFeewnerSelect(stmtOptions);
	}
}
