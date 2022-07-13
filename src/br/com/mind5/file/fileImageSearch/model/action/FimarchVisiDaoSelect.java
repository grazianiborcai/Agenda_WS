package br.com.mind5.file.fileImageSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.file.fileImageSearch.dao.FimarchDaoSelect;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimarchVisiDaoSelect extends ActionVisitorTemplateStmt<FimarchInfo> {

	public FimarchVisiDaoSelect(DeciTreeOption<FimarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FimarchInfo> buildStmtExecHook(List<DaoStmtExecOption<FimarchInfo>> stmtOptions) {
		return new FimarchDaoSelect(stmtOptions);
	}
}
