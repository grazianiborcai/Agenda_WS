package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.business.scheduleAuthorization.model.decisionTree.RootSchedauthMove;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineSchedauthMove extends ActionVisitorTemplateActionV2<SchedineInfo, SchedauthInfo> {

	public VisiSchedineSchedauthMove(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, SchedauthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedauthInfo>> getTreeClassHook() {
		return RootSchedauthMove.class;
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<SchedauthInfo> results) {
		return baseInfos;
	}
}
