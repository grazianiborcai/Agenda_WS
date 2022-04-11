package br.com.mind5.business.personBioSearch.model.action;

import java.util.List;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.model.decisionTree.PerbiorchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbiorchVisiRootSelect extends ActionVisitorTemplateAction<PerbiorchInfo, PerbiorchInfo> {

	public PerbiorchVisiRootSelect(DeciTreeOption<PerbiorchInfo> option) {
		super(option, PerbiorchInfo.class, PerbiorchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerbiorchInfo>> getTreeClassHook() {
		return PerbiorchRootSelect.class;
	}
	
	
	
	@Override protected List<PerbiorchInfo> toBaseClassHook(List<PerbiorchInfo> baseInfos, List<PerbiorchInfo> results) {
		return results;
	}
}
