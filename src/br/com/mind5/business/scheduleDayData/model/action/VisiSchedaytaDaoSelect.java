package br.com.mind5.business.scheduleDayData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleDayData.dao.DaoSchedaytaSelect;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedaytaDaoSelect extends ActionVisitorTemplateStmtV2<SchedaytaInfo>{

	public VisiSchedaytaDaoSelect(DeciTreeOption<SchedaytaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SchedaytaInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedaytaInfo>> stmtOptions) {
		return new DaoSchedaytaSelect(stmtOptions);
	}
}
