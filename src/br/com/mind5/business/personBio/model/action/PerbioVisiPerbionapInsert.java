package br.com.mind5.business.personBio.model.action;

import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.info.PerbioMerger;
import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.business.personBioSnapshot.model.decisionTree.PerbionapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbioVisiPerbionapInsert extends ActionVisitorTemplateAction<PerbioInfo, PerbionapInfo> {

	public PerbioVisiPerbionapInsert(DeciTreeOption<PerbioInfo> option) {
		super(option, PerbioInfo.class, PerbionapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerbionapInfo>> getTreeClassHook() {
		return PerbionapRootInsert.class;
	}
	
	
	
	protected List<PerbioInfo> toBaseClassHook(List<PerbioInfo> baseInfos, List<PerbionapInfo> selectedInfos) {
		return PerbioMerger.mergeWithPerbionap(baseInfos, selectedInfos);
	}
}
