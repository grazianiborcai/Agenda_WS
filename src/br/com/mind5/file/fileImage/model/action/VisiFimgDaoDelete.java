package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.file.fileImage.dao.DaoFimgDelete;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgDaoDelete extends ActionVisitorTemplateStmtV2<FimgInfo> {

	public VisiFimgDaoDelete(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<FimgInfo> buildStmtExecHook(List<DaoStmtExecOption<FimgInfo>> stmtOptions) {
		return new DaoFimgDelete(stmtOptions);
	}
}