package br.com.mind5.masterData.orderStatusSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.orderStatusSearch.dao.DaoOrderatarchSelect;
import br.com.mind5.masterData.orderStatusSearch.info.OrderatarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderatarchDaoSelect extends ActionVisitorTemplateStmt<OrderatarchInfo> {

	public VisiOrderatarchDaoSelect(DeciTreeOption<OrderatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OrderatarchInfo> buildStmtExecHook(List<DaoStmtExecOption<OrderatarchInfo>> stmtOptions) {
		return new DaoOrderatarchSelect(stmtOptions);
	}
}
