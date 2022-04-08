package br.com.mind5.business.materialText.model.action;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.decisionTree.MatextNodeDeleteL2;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextVisiNodeDeleteL2 extends ActionVisitorTemplateAction<MatextInfo, MatextInfo> {

	public MatextVisiNodeDeleteL2(DeciTreeOption<MatextInfo> option) {
		super(option, MatextInfo.class, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextInfo>> getTreeClassHook() {
		return MatextNodeDeleteL2.class;
	}
	
	
	
	@Override protected List<MatextInfo> toBaseClassHook(List<MatextInfo> baseInfos, List<MatextInfo> results) {
		return results;
	}
}
