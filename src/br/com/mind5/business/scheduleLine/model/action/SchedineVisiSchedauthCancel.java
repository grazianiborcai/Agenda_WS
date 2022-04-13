package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.authorization.scheduleAuthorization.model.decisionTree.SchedauthRootCancel;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiSchedauthCancel extends ActionVisitorTemplateAction<SchedineInfo, SchedauthInfo> {

	public SchedineVisiSchedauthCancel(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, SchedauthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedauthInfo>> getTreeClassHook() {
		return SchedauthRootCancel.class;
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<SchedauthInfo> results) {
		return baseInfos;
	}
}
