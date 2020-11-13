package br.com.mind5.payment.storePartnerSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.dao.DaoStoparchSelect;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

final class VisiStoparchDaoSelect extends ActionVisitorTemplateStmt<StoparchInfo> {

	public VisiStoparchDaoSelect(DeciTreeOption<StoparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StoparchInfo> buildStmtExecHook(List<DaoStmtExecOption<StoparchInfo>> stmtOptions) {
		return new DaoStoparchSelect(stmtOptions);
	}
}
