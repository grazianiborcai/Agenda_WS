package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.model.decisionTree.RootMatsnapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatMatsnapInsert extends ActionVisitorTemplateActionV2<MatInfo, MatsnapInfo> {

	public VisiMatMatsnapInsert(DeciTreeOption<MatInfo> option) {
		super(option, MatInfo.class, MatsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatsnapInfo>> getTreeClassHook() {
		return RootMatsnapInsert.class;
	}
	
	
	
	protected List<MatInfo> toBaseClassHook(List<MatInfo> baseInfos, List<MatsnapInfo> results) {
		return MatMerger.mergeWithMatsnap(baseInfos, results);
	}
}
