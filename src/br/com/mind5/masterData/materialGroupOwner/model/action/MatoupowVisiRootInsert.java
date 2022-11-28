package br.com.mind5.masterData.materialGroupOwner.model.action;

import java.util.List;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.decisionTree.MatoupowRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowVisiRootInsert extends ActionVisitorTemplateAction<MatoupowInfo, MatoupowInfo> {

	public MatoupowVisiRootInsert(DeciTreeOption<MatoupowInfo> option) {
		super(option, MatoupowInfo.class, MatoupowInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoupowInfo>> getTreeClassHook() {
		return MatoupowRootInsert.class;
	}
	
	
	
	@Override protected List<MatoupowInfo> toBaseClassHook(List<MatoupowInfo> baseInfos, List<MatoupowInfo> results) {
		return results;
	}
}
