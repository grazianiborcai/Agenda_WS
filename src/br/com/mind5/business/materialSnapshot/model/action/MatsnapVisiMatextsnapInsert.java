package br.com.mind5.business.materialSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.business.materialTextSnapshot.model.decisionTree.MatextsnapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatsnapVisiMatextsnapInsert extends ActionVisitorTemplateAction<MatsnapInfo, MatextsnapInfo> {

	public MatsnapVisiMatextsnapInsert(DeciTreeOption<MatsnapInfo> option) {
		super(option, MatsnapInfo.class, MatextsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextsnapInfo>> getTreeClassHook() {
		return MatextsnapRootInsert.class;
	}
	
	
	
	protected List<MatsnapInfo> toBaseClassHook(List<MatsnapInfo> baseInfos, List<MatextsnapInfo> results) {
		return baseInfos;
	}
}
