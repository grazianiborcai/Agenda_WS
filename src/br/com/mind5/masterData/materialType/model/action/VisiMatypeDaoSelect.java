package br.com.mind5.masterData.materialType.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialType.dao.DaoMatypeSelect;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatypeDaoSelect extends ActionVisitorTemplateStmt<MatypeInfo> {

	public VisiMatypeDaoSelect(DeciTreeOption<MatypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatypeInfo> buildStmtExecHook(List<DaoStmtExecOption<MatypeInfo>> stmtOptions) {
		return new DaoMatypeSelect(stmtOptions);
	}
}
