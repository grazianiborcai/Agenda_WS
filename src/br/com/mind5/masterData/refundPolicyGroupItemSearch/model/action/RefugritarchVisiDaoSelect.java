package br.com.mind5.masterData.refundPolicyGroupItemSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.dao.RefugritarchDaoSelect;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugritarchVisiDaoSelect extends ActionVisitorTemplateStmt<RefugritarchInfo> {

	public RefugritarchVisiDaoSelect(DeciTreeOption<RefugritarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<RefugritarchInfo> buildStmtExecHook(List<DaoStmtExecOption<RefugritarchInfo>> stmtOptions) {
		return new RefugritarchDaoSelect(stmtOptions);
	}
}
