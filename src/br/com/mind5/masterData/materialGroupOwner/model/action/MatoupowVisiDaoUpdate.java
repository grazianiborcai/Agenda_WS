package br.com.mind5.masterData.materialGroupOwner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.materialGroupOwner.dao.MatoupowDaoUpdate;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowVisiDaoUpdate extends ActionVisitorTemplateStmt<MatoupowInfo> {

	public MatoupowVisiDaoUpdate(DeciTreeOption<MatoupowInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatoupowInfo> buildStmtExecHook(List<DaoStmtExecOption<MatoupowInfo>> stmtOptions) {
		return new MatoupowDaoUpdate(stmtOptions);
	}
}
