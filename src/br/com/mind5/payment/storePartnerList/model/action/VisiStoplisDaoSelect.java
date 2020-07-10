package br.com.mind5.payment.storePartnerList.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.dao.DaoStoplisSelect;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

final class VisiStoplisDaoSelect extends ActionVisitorTemplateStmtV2<StoplisInfo> {

	public VisiStoplisDaoSelect(DeciTreeOption<StoplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StoplisInfo> buildStmtExecHook(List<DaoStmtExecOption<StoplisInfo>> stmtOptions) {
		return new DaoStoplisSelect(stmtOptions);
	}
}
