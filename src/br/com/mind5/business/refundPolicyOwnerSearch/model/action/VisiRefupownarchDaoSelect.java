package br.com.mind5.business.refundPolicyOwnerSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.business.refundPolicyOwnerSearch.dao.DaoRefupownarchSelect;
import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupownarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupownarchDaoSelect extends ActionVisitorTemplateStmtV2<RefupownarchInfo>{

	public VisiRefupownarchDaoSelect(DeciTreeOption<RefupownarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<RefupownarchInfo> buildStmtExecHook(List<DaoStmtExecOption<RefupownarchInfo>> stmtOptions) {
		return new DaoRefupownarchSelect(stmtOptions);
	}
}
