package br.com.mind5.business.orderList.model.action;

import java.util.List;

import br.com.mind5.business.orderList.dao.OrdistDaoSelect;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdistVisiDaoSelect extends ActionVisitorTemplateStmt<OrdistInfo> {

	public OrdistVisiDaoSelect(DeciTreeOption<OrdistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrdistInfo> buildStmtExecHook(List<DaoStmtExecOption<OrdistInfo>> stmtOptions) {
		return new OrdistDaoSelect(stmtOptions);
	}
}
