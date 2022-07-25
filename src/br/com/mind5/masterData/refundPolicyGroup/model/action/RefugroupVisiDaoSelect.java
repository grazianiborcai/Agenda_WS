package br.com.mind5.masterData.refundPolicyGroup.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.refundPolicyGroup.dao.RefugroupDaoSelect;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugroupVisiDaoSelect extends ActionVisitorTemplateStmt<RefugroupInfo> {

	public RefugroupVisiDaoSelect(DeciTreeOption<RefugroupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<RefugroupInfo> buildStmtExecHook(List<DaoStmtExecOption<RefugroupInfo>> stmtOptions) {
		return new RefugroupDaoSelect(stmtOptions);
	}
}
