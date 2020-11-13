package br.com.mind5.masterData.refundPolicyGroupItem.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.refundPolicyGroupItem.dao.DaoRefugritemSelect;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefugritemDaoSelect extends ActionVisitorTemplateStmt<RefugritemInfo> {

	public VisiRefugritemDaoSelect(DeciTreeOption<RefugritemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<RefugritemInfo> buildStmtExecHook(List<DaoStmtExecOption<RefugritemInfo>> stmtOptions) {
		return new DaoRefugritemSelect(stmtOptions);
	}
}
