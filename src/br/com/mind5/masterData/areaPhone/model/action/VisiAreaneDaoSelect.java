package br.com.mind5.masterData.areaPhone.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.areaPhone.dao.DaoAreaneSelect;
import br.com.mind5.masterData.areaPhone.info.AreaneInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAreaneDaoSelect extends ActionVisitorTemplateStmtV2<AreaneInfo>{

	public VisiAreaneDaoSelect(DeciTreeOption<AreaneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<AreaneInfo> buildStmtExecHook(List<DaoStmtExecOption<AreaneInfo>> stmtOptions) {
		return new DaoAreaneSelect(stmtOptions);
	}
}
