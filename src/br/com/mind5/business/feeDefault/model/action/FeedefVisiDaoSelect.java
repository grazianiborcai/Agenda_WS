package br.com.mind5.business.feeDefault.model.action;

import java.util.List;

import br.com.mind5.business.feeDefault.dao.FeedefDaoSelect;
import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeedefVisiDaoSelect extends ActionVisitorTemplateStmt<FeedefInfo> {

	public FeedefVisiDaoSelect(DeciTreeOption<FeedefInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FeedefInfo> buildStmtExecHook(List<DaoStmtExecOption<FeedefInfo>> stmtOptions) {
		return new FeedefDaoSelect(stmtOptions);
	}
}
