package br.com.mind5.business.refundPolicyStoreSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.business.refundPolicyStoreSearch.dao.DaoRefuporerchSelect;
import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporerchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefuporerchDaoSelect extends ActionVisitorTemplateStmtV2<RefuporerchInfo>{

	public VisiRefuporerchDaoSelect(DeciTreeOption<RefuporerchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<RefuporerchInfo> buildStmtExecHook(List<DaoStmtExecOption<RefuporerchInfo>> stmtOptions) {
		return new DaoRefuporerchSelect(stmtOptions);
	}
}
