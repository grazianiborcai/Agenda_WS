package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.message.emailScheduleCancellation.model.decisionTree.RootEmulelSend;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineEmulelSend extends ActionVisitorTemplateAction<SchedineInfo, EmulelInfo> {

	public VisiSchedineEmulelSend(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, EmulelInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmulelInfo>> getTreeClassHook() {
		return RootEmulelSend.class;
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<EmulelInfo> results) {
		return baseInfos;
	}
}
