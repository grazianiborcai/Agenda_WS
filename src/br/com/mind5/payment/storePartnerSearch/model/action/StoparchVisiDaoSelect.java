package br.com.mind5.payment.storePartnerSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.dao.StoparchDaoSelect;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StoparchVisiDaoSelect extends ActionVisitorTemplateStmt<StoparchInfo> {

	public StoparchVisiDaoSelect(DeciTreeOption<StoparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoparchInfo> buildStmtExecHook(List<DaoStmtExecOption<StoparchInfo>> stmtOptions) {
		return new StoparchDaoSelect(stmtOptions);
	}
}
