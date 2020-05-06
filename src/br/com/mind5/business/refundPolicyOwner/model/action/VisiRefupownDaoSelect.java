package br.com.mind5.business.refundPolicyOwner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.business.refundPolicyOwner.dao.DaoRefupownSelect;
import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupownDaoSelect extends ActionVisitorTemplateStmtV2<RefupownInfo>{

	public VisiRefupownDaoSelect(DeciTreeOption<RefupownInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<RefupownInfo> buildStmtExecHook(List<DaoStmtExecOption<RefupownInfo>> stmtOptions) {
		return new DaoRefupownSelect(stmtOptions);
	}
}
