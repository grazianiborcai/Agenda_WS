package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.file.fileImage.dao.DaoFimgSelect;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgDaoSelect extends ActionVisitorTemplateStmt<FimgInfo> {

	public VisiFimgDaoSelect(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FimgInfo> buildStmtExecHook(List<DaoStmtExecOption<FimgInfo>> stmtOptions) {
		return new DaoFimgSelect(stmtOptions);
	}
}
