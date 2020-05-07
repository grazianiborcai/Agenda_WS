package br.com.mind5.masterData.refundPolicyGroupItemSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.dao.DaoRefugritarchSelect;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefugritarchDaoSelect extends ActionVisitorTemplateStmtV2<RefugritarchInfo>{

	public VisiRefugritarchDaoSelect(DeciTreeOption<RefugritarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<RefugritarchInfo> buildStmtExecHook(List<DaoStmtExecOption<RefugritarchInfo>> stmtOptions) {
		return new DaoRefugritarchSelect(stmtOptions);
	}
}
