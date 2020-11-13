package br.com.mind5.masterData.refundPolicy.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.refundPolicy.dao.DaoRefupoSelect;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupoDaoSelect extends ActionVisitorTemplateStmt<RefupoInfo> {

	public VisiRefupoDaoSelect(DeciTreeOption<RefupoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<RefupoInfo> buildStmtExecHook(List<DaoStmtExecOption<RefupoInfo>> stmtOptions) {
		return new DaoRefupoSelect(stmtOptions);
	}
}
