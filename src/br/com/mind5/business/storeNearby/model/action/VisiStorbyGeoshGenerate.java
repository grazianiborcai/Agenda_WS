package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbyMerger;
import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.geo.geoHash.model.decisionTree.RootGeoshGenerate;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorbyGeoshGenerate extends ActionVisitorTemplateAction<StorbyInfo, GeoshInfo> {

	public VisiStorbyGeoshGenerate(DeciTreeOption<StorbyInfo> option) {
		super(option, StorbyInfo.class, GeoshInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<GeoshInfo>> getTreeClassHook() {
		return RootGeoshGenerate.class;
	}
	
	
	
	@Override protected List<StorbyInfo> toBaseClassHook(List<StorbyInfo> baseInfos, List<GeoshInfo> results) {
		return StorbyMerger.mergeWithGeosh(baseInfos, results);
	}
}
