package br.com.mind5.masterData.materialGroup.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialGroup.dao.DaoMatoupSelect;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoupDaoSelect extends ActionVisitorTemplateStmtV2<MatoupInfo> {

	public VisiMatoupDaoSelect(DeciTreeOption<MatoupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatoupInfo> buildStmtExecHook(List<DaoStmtExecOption<MatoupInfo>> stmtOptions) {
		return new DaoMatoupSelect(stmtOptions);
	}
}
