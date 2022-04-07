package br.com.mind5.business.materialMovement.model.action;

import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.decisionTree.MatmovRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatmovVisiRootSelect extends ActionVisitorTemplateAction<MatmovInfo, MatmovInfo> {

	public MatmovVisiRootSelect(DeciTreeOption<MatmovInfo> option) {
		super(option, MatmovInfo.class, MatmovInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatmovInfo>> getTreeClassHook() {
		return MatmovRootSelect.class;
	}
	
	
	
	@Override protected List<MatmovInfo> toBaseClassHook(List<MatmovInfo> baseInfos, List<MatmovInfo> results) {
		return results;
	}
}
