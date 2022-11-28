package br.com.mind5.masterData.materialGroupOwner.model.action;

import java.util.List;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.decisionTree.MatoupowNodeSelectL2;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowVisiNodeSelectL2 extends ActionVisitorTemplateAction<MatoupowInfo, MatoupowInfo> {

	public MatoupowVisiNodeSelectL2(DeciTreeOption<MatoupowInfo> option) {
		super(option, MatoupowInfo.class, MatoupowInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoupowInfo>> getTreeClassHook() {
		return MatoupowNodeSelectL2.class;
	}
	
	
	
	@Override protected List<MatoupowInfo> toBaseClassHook(List<MatoupowInfo> baseInfos, List<MatoupowInfo> results) {
		return results;
	}
}
