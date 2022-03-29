package br.com.mind5.business.ownerList.model.action;

import java.util.List;

import br.com.mind5.business.ownerList.dao.OwnelisDaoSelect;
import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnelisVisiDaoSelect extends ActionVisitorTemplateStmt<OwnelisInfo> {

	public OwnelisVisiDaoSelect(DeciTreeOption<OwnelisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OwnelisInfo> buildStmtExecHook(List<DaoStmtExecOption<OwnelisInfo>> stmtOptions) {
		return new OwnelisDaoSelect(stmtOptions);
	}
}
