package br.com.mind5.business.orderList.model.action;

import java.util.List;

import br.com.mind5.business.orderList.dao.DaoOrdistSelect;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdistDaoSelect extends ActionVisitorTemplateStmtV2<OrdistInfo> {

	public VisiOrdistDaoSelect(DeciTreeOption<OrdistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OrdistInfo> buildStmtExecHook(List<DaoStmtExecOption<OrdistInfo>> stmtOptions) {
		return new DaoOrdistSelect(stmtOptions);
	}
}
