package br.com.mind5.masterData.position.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.position.dao.DaoPositionSelect;
import br.com.mind5.masterData.position.info.PositionInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPositionDaoSelect extends ActionVisitorTemplateStmt<PositionInfo> {

	public VisiPositionDaoSelect(DeciTreeOption<PositionInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PositionInfo> buildStmtExecHook(List<DaoStmtExecOption<PositionInfo>> stmtOptions) {
		return new DaoPositionSelect(stmtOptions);
	}
}
