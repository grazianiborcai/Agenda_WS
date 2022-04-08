package br.com.mind5.business.materialStore.model.action;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.info.MatoreMerger;
import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.business.materialStoreSnapshot.model.decisionTree.MatorapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoreVisiMatorapInsert extends ActionVisitorTemplateAction<MatoreInfo, MatorapInfo> {

	public MatoreVisiMatorapInsert(DeciTreeOption<MatoreInfo> option) {
		super(option, MatoreInfo.class, MatorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatorapInfo>> getTreeClassHook() {
		return MatorapRootInsert.class;
	}
	
	
	
	protected List<MatoreInfo> toBaseClassHook(List<MatoreInfo> baseInfos, List<MatorapInfo> results) {
		return MatoreMerger.mergeWithMatorap(baseInfos, results);
	}
}
