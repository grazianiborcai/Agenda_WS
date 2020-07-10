package br.com.mind5.masterData.materialCategory.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialCategory.dao.DaoMategSelect;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMategDaoSelect extends ActionVisitorTemplateStmtV2<MategInfo> {

	public VisiMategDaoSelect(DeciTreeOption<MategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MategInfo> buildStmtExecHook(List<DaoStmtExecOption<MategInfo>> stmtOptions) {
		return new DaoMategSelect(stmtOptions);
	}
}
