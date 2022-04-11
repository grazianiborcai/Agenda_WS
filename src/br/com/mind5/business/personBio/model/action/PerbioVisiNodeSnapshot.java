package br.com.mind5.business.personBio.model.action;

import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.decisionTree.PerbioNodeSnapshot;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbioVisiNodeSnapshot extends ActionVisitorTemplateAction<PerbioInfo, PerbioInfo> {

	public PerbioVisiNodeSnapshot(DeciTreeOption<PerbioInfo> option) {
		super(option, PerbioInfo.class, PerbioInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerbioInfo>> getTreeClassHook() {
		return PerbioNodeSnapshot.class;
	}
	
	
	
	@Override protected List<PerbioInfo> toBaseClassHook(List<PerbioInfo> baseInfos, List<PerbioInfo> results) {
		return results;
	}
}
