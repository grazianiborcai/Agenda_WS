package br.com.mind5.masterData.refundPolicyGroupHeaderSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.refundPolicyGroupHeaderSearch.dao.DaoRefugradarchSelect;
import br.com.mind5.masterData.refundPolicyGroupHeaderSearch.info.RefugradarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefugradarchDaoSelect extends ActionVisitorTemplateStmtV2<RefugradarchInfo>{

	public VisiRefugradarchDaoSelect(DeciTreeOption<RefugradarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<RefugradarchInfo> buildStmtExecHook(List<DaoStmtExecOption<RefugradarchInfo>> stmtOptions) {
		return new DaoRefugradarchSelect(stmtOptions);
	}
}
