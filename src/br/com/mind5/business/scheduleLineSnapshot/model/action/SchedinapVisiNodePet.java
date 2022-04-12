package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.model.decisionTree.SchedinapNodePet;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedinapVisiNodePet extends ActionVisitorTemplateAction<SchedinapInfo, SchedinapInfo> {

	public SchedinapVisiNodePet(DeciTreeOption<SchedinapInfo> option) {
		super(option, SchedinapInfo.class, SchedinapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedinapInfo>> getTreeClassHook() {
		return SchedinapNodePet.class;
	}
	
	
	
	@Override protected List<SchedinapInfo> toBaseClassHook(List<SchedinapInfo> baseInfos, List<SchedinapInfo> results) {
		return results;
	}
}
