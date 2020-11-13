package br.com.mind5.masterData.materialCategory.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialCategory.dao.DaoMategSelect;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMategDaoSelect extends ActionVisitorTemplateStmt<MategInfo> {

	public VisiMategDaoSelect(DeciTreeOption<MategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MategInfo> buildStmtExecHook(List<DaoStmtExecOption<MategInfo>> stmtOptions) {
		return new DaoMategSelect(stmtOptions);
	}
}
