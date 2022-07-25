package br.com.mind5.masterData.position.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.position.dao.PositionDaoSelect;
import br.com.mind5.masterData.position.info.PositionInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PositionVisiDaoSelect extends ActionVisitorTemplateStmt<PositionInfo> {

	public PositionVisiDaoSelect(DeciTreeOption<PositionInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PositionInfo> buildStmtExecHook(List<DaoStmtExecOption<PositionInfo>> stmtOptions) {
		return new PositionDaoSelect(stmtOptions);
	}
}
