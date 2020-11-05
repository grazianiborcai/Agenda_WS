package br.com.mind5.file.filePath.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.file.filePath.dao.DaoFathSelect;
import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFathDaoSelect extends ActionVisitorTemplateStmtV2<FathInfo> {

	public VisiFathDaoSelect(DeciTreeOption<FathInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<FathInfo> buildStmtExecHook(List<DaoStmtExecOption<FathInfo>> stmtOptions) {
		return new DaoFathSelect(stmtOptions);
	}
}
