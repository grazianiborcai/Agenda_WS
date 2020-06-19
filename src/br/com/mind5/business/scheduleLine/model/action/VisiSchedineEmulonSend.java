package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.message.emailScheduleConfirmation.info.EmulonInfo;
import br.com.mind5.message.emailScheduleConfirmation.model.decisionTree.RootEmulonSend;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineEmulonSend extends ActionVisitorTemplateActionV2<SchedineInfo, EmulonInfo> {

	public VisiSchedineEmulonSend(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, EmulonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmulonInfo>> getTreeClassHook() {
		return RootEmulonSend.class;
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<EmulonInfo> results) {
		return baseInfos;
	}
}
