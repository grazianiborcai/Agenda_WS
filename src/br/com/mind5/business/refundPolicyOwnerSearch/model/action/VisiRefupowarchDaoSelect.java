package br.com.mind5.business.refundPolicyOwnerSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.business.refundPolicyOwnerSearch.dao.DaoRefupowarchSelect;
import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupowarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupowarchDaoSelect extends ActionVisitorTemplateStmtV2<RefupowarchInfo>{

	public VisiRefupowarchDaoSelect(DeciTreeOption<RefupowarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<RefupowarchInfo> buildStmtExecHook(List<DaoStmtExecOption<RefupowarchInfo>> stmtOptions) {
		return new DaoRefupowarchSelect(stmtOptions);
	}
}
