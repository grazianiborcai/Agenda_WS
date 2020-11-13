package br.com.mind5.business.ownerList.model.action;

import java.util.List;

import br.com.mind5.business.ownerList.dao.DaoOwnelisSelect;
import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnelisDaoSelect extends ActionVisitorTemplateStmt<OwnelisInfo> {

	public VisiOwnelisDaoSelect(DeciTreeOption<OwnelisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OwnelisInfo> buildStmtExecHook(List<DaoStmtExecOption<OwnelisInfo>> stmtOptions) {
		return new DaoOwnelisSelect(stmtOptions);
	}
}
