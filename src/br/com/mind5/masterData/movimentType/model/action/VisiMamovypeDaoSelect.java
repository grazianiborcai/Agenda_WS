package br.com.mind5.masterData.movimentType.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.movimentType.dao.DaoMamovypeSelect;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMamovypeDaoSelect extends ActionVisitorTemplateStmt<MamovypeInfo> {

	public VisiMamovypeDaoSelect(DeciTreeOption<MamovypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MamovypeInfo> buildStmtExecHook(List<DaoStmtExecOption<MamovypeInfo>> stmtOptions) {
		return new DaoMamovypeSelect(stmtOptions);
	}
}
