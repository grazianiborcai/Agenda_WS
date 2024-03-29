package br.com.mind5.masterData.refundPolicyGroupSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.refundPolicyGroupSearch.dao.RefugrarchDaoSelect;
import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugrarchVisiDaoSelect extends ActionVisitorTemplateStmt<RefugrarchInfo> {

	public RefugrarchVisiDaoSelect(DeciTreeOption<RefugrarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<RefugrarchInfo> buildStmtExecHook(List<DaoStmtExecOption<RefugrarchInfo>> stmtOptions) {
		return new RefugrarchDaoSelect(stmtOptions);
	}
}
