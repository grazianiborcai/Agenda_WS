package br.com.mind5.masterData.areaPhone.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.areaPhone.dao.DaoAreaneSelect;
import br.com.mind5.masterData.areaPhone.info.AreaneInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAreaneDaoSelect extends ActionVisitorTemplateStmt<AreaneInfo> {

	public VisiAreaneDaoSelect(DeciTreeOption<AreaneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<AreaneInfo> buildStmtExecHook(List<DaoStmtExecOption<AreaneInfo>> stmtOptions) {
		return new DaoAreaneSelect(stmtOptions);
	}
}
