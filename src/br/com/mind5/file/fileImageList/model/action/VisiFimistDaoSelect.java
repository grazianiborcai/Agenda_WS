package br.com.mind5.file.fileImageList.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.file.fileImageList.dao.DaoFimistSelect;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimistDaoSelect extends ActionVisitorTemplateStmtV2<FimistInfo> {

	public VisiFimistDaoSelect(DeciTreeOption<FimistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<FimistInfo> buildStmtExecHook(List<DaoStmtExecOption<FimistInfo>> stmtOptions) {
		return new DaoFimistSelect(stmtOptions);
	}
}
