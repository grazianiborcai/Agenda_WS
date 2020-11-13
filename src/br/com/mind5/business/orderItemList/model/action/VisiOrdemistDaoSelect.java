package br.com.mind5.business.orderItemList.model.action;

import java.util.List;

import br.com.mind5.business.orderItemList.dao.DaoOrdemistSelect;
import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdemistDaoSelect extends ActionVisitorTemplateStmt<OrdemistInfo> {

	public VisiOrdemistDaoSelect(DeciTreeOption<OrdemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OrdemistInfo> buildStmtExecHook(List<DaoStmtExecOption<OrdemistInfo>> stmtOptions) {
		return new DaoOrdemistSelect(stmtOptions);
	}
}
