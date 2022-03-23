package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.message.emailScheduleConfirmation.info.EmulonInfo;
import br.com.mind5.message.emailScheduleConfirmation.model.decisionTree.RootEmulonSend;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiEmulonSend extends ActionVisitorTemplateAction<SchedineInfo, EmulonInfo> {

	public SchedineVisiEmulonSend(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, EmulonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmulonInfo>> getTreeClassHook() {
		return RootEmulonSend.class;
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<EmulonInfo> results) {
		return baseInfos;
	}
}
