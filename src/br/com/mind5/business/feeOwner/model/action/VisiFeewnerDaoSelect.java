package br.com.mind5.business.feeOwner.model.action;

import java.util.List;

import br.com.mind5.business.feeOwner.dao.DaoFeewnerSelect;
import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFeewnerDaoSelect extends ActionVisitorTemplateStmtV2<FeewnerInfo> {

	public VisiFeewnerDaoSelect(DeciTreeOption<FeewnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<FeewnerInfo> buildStmtExecHook(List<DaoStmtExecOption<FeewnerInfo>> stmtOptions) {
		return new DaoFeewnerSelect(stmtOptions);
	}
}
