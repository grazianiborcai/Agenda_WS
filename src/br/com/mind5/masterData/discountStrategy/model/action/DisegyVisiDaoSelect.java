package br.com.mind5.masterData.discountStrategy.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.discountStrategy.dao.DisegyDaoSelect;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisegyVisiDaoSelect extends ActionVisitorTemplateStmt<DisegyInfo> {

	public DisegyVisiDaoSelect(DeciTreeOption<DisegyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<DisegyInfo> buildStmtExecHook(List<DaoStmtExecOption<DisegyInfo>> stmtOptions) {
		return new DisegyDaoSelect(stmtOptions);
	}
}
