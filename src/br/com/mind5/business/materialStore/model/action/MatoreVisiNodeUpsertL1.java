package br.com.mind5.business.materialStore.model.action;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.MatoreNodeUpsertL1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoreVisiNodeUpsertL1 extends ActionVisitorTemplateAction<MatoreInfo, MatoreInfo> {

	public MatoreVisiNodeUpsertL1(DeciTreeOption<MatoreInfo> option) {
		super(option, MatoreInfo.class, MatoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoreInfo>> getTreeClassHook() {
		return MatoreNodeUpsertL1.class;
	}
	
	
	
	@Override protected List<MatoreInfo> toBaseClassHook(List<MatoreInfo> baseInfos, List<MatoreInfo> results) {
		return results;
	}
}
