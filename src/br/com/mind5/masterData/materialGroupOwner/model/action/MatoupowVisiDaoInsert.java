package br.com.mind5.masterData.materialGroupOwner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.materialGroupOwner.dao.MatoupowDaoInsert;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowVisiDaoInsert extends ActionVisitorTemplateStmt<MatoupowInfo> {

	public MatoupowVisiDaoInsert(DeciTreeOption<MatoupowInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatoupowInfo> buildStmtExecHook(List<DaoStmtExecOption<MatoupowInfo>> stmtOptions) {
		return new MatoupowDaoInsert(stmtOptions);
	}
}
