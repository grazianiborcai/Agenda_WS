package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.file.fileImage.dao.DaoFimgUpdate;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgDaoUpdate extends ActionVisitorTemplateStmt<FimgInfo> {

	public VisiFimgDaoUpdate(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<FimgInfo> buildStmtExecHook(List<DaoStmtExecOption<FimgInfo>> stmtOptions) {
		return new DaoFimgUpdate(stmtOptions);
	}
}
