package br.com.mind5.masterData.materialCategory.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialCategory.dao.MategDaoSelect;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MategVisiDaoSelect extends ActionVisitorTemplateStmt<MategInfo> {

	public MategVisiDaoSelect(DeciTreeOption<MategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MategInfo> buildStmtExecHook(List<DaoStmtExecOption<MategInfo>> stmtOptions) {
		return new MategDaoSelect(stmtOptions);
	}
}
