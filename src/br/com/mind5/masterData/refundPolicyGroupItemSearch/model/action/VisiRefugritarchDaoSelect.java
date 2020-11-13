package br.com.mind5.masterData.refundPolicyGroupItemSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.dao.DaoRefugritarchSelect;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefugritarchDaoSelect extends ActionVisitorTemplateStmt<RefugritarchInfo> {

	public VisiRefugritarchDaoSelect(DeciTreeOption<RefugritarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<RefugritarchInfo> buildStmtExecHook(List<DaoStmtExecOption<RefugritarchInfo>> stmtOptions) {
		return new DaoRefugritarchSelect(stmtOptions);
	}
}
