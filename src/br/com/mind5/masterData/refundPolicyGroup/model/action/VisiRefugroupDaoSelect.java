package br.com.mind5.masterData.refundPolicyGroup.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.refundPolicyGroup.dao.DaoRefugroupSelect;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefugroupDaoSelect extends ActionVisitorTemplateStmt<RefugroupInfo> {

	public VisiRefugroupDaoSelect(DeciTreeOption<RefugroupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<RefugroupInfo> buildStmtExecHook(List<DaoStmtExecOption<RefugroupInfo>> stmtOptions) {
		return new DaoRefugroupSelect(stmtOptions);
	}
}
