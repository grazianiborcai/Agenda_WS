package br.com.mind5.business.orderItemList.model.action;

import java.util.List;

import br.com.mind5.business.orderItemList.dao.OrdemistDaoSelect;
import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdemistVisiDaoSelect extends ActionVisitorTemplateStmt<OrdemistInfo> {

	public OrdemistVisiDaoSelect(DeciTreeOption<OrdemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrdemistInfo> buildStmtExecHook(List<DaoStmtExecOption<OrdemistInfo>> stmtOptions) {
		return new OrdemistDaoSelect(stmtOptions);
	}
}
