package br.com.mind5.payment.storePartnerList.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.dao.StoplisDaoSelect;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StoplisVisiDaoSelect extends ActionVisitorTemplateStmt<StoplisInfo> {

	public StoplisVisiDaoSelect(DeciTreeOption<StoplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoplisInfo> buildStmtExecHook(List<DaoStmtExecOption<StoplisInfo>> stmtOptions) {
		return new StoplisDaoSelect(stmtOptions);
	}
}
