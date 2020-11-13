package br.com.mind5.business.materialList.model.action;

import java.util.List;

import br.com.mind5.business.materialList.dao.DaoMatlisSelect;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatlisDaoSelect extends ActionVisitorTemplateStmt<MatlisInfo> {

	public VisiMatlisDaoSelect(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatlisInfo> buildStmtExecHook(List<DaoStmtExecOption<MatlisInfo>> stmtOptions) {
		return new DaoMatlisSelect(stmtOptions);
	}
}
