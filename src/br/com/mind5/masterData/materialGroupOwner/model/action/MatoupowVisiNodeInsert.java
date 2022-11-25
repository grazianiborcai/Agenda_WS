package br.com.mind5.masterData.materialGroupOwner.model.action;

import java.util.List;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.decisionTree.MatoupowNodeInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowVisiNodeInsert extends ActionVisitorTemplateAction<MatoupowInfo, MatoupowInfo> {

	public MatoupowVisiNodeInsert(DeciTreeOption<MatoupowInfo> option) {
		super(option, MatoupowInfo.class, MatoupowInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoupowInfo>> getTreeClassHook() {
		return MatoupowNodeInsert.class;
	}
	
	
	
	@Override protected List<MatoupowInfo> toBaseClassHook(List<MatoupowInfo> baseInfos, List<MatoupowInfo> results) {
		return results;
	}
}
