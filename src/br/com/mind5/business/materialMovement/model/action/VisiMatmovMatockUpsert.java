package br.com.mind5.business.materialMovement.model.action;

import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovMerger;
import br.com.mind5.business.materialStock.info.MatockCopier;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.decisionTree.RootMatockUpsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatmovMatockUpsert extends ActionVisitorTemplateAction<MatmovInfo, MatockInfo> {
	
	public VisiMatmovMatockUpsert(DeciTreeOption<MatmovInfo> option) {
		super(option, MatmovInfo.class, MatockInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatockInfo>> getTreeClassHook() {
		return RootMatockUpsert.class;
	}
	
	
	
	@Override protected List<MatockInfo> toActionClassHook(List<MatmovInfo> recordInfos) {
		return MatockCopier.copyFromMatmov(recordInfos);
	}
	
	
	
	@Override protected List<MatmovInfo> toBaseClassHook(List<MatmovInfo> baseInfos, List<MatockInfo> results) {
		return MatmovMerger.mergeWithMatock(baseInfos, results);
	}
}
