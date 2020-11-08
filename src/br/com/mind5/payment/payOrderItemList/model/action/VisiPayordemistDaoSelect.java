package br.com.mind5.payment.payOrderItemList.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.dao.DaoPayordemistSelect;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

final class VisiPayordemistDaoSelect extends ActionVisitorTemplateStmtV2<PayordemistInfo> {

	public VisiPayordemistDaoSelect(DeciTreeOption<PayordemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PayordemistInfo> buildStmtExecHook(List<DaoStmtExecOption<PayordemistInfo>> stmtOptions) {
		return new DaoPayordemistSelect(stmtOptions);
	}
}
