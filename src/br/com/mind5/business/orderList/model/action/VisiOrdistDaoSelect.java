package br.com.mind5.business.orderList.model.action;

import java.util.List;

import br.com.mind5.business.orderList.dao.DaoOrdistSelect;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdistDaoSelect extends ActionVisitorTemplateStmt<OrdistInfo> {

	public VisiOrdistDaoSelect(DeciTreeOption<OrdistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrdistInfo> buildStmtExecHook(List<DaoStmtExecOption<OrdistInfo>> stmtOptions) {
		return new DaoOrdistSelect(stmtOptions);
	}
}
