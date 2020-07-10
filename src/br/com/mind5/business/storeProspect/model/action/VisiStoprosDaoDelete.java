package br.com.mind5.business.storeProspect.model.action;

import java.util.List;

import br.com.mind5.business.storeProspect.dao.DaoStoprosDelete;
import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoprosDaoDelete extends ActionVisitorTemplateStmtV2<StoprosInfo> {

	public VisiStoprosDaoDelete(DeciTreeOption<StoprosInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StoprosInfo> buildStmtExecHook(List<DaoStmtExecOption<StoprosInfo>> stmtOptions) {
		return new DaoStoprosDelete(stmtOptions);
	}
}
