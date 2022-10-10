package br.com.mind5.geo.geoCode.model.action;

import java.util.List;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.geo.geoCode.info.GeodeMerger;
import br.com.mind5.geo.geoMapquest.info.GeoquestInfo;
import br.com.mind5.geo.geoMapquest.model.decisionTree.GeoquestRootCoding;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class GeodeVisiGeoquestCoding extends ActionVisitorTemplateAction<GeodeInfo, GeoquestInfo> {
	
	public GeodeVisiGeoquestCoding(DeciTreeOption<GeodeInfo> option) {
		super(option, GeodeInfo.class, GeoquestInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<GeoquestInfo>> getTreeClassHook() {
		return GeoquestRootCoding.class;
	}
	
	
	
	@Override protected List<GeodeInfo> toBaseClassHook(List<GeodeInfo> baseInfos, List<GeoquestInfo> results) {
		return GeodeMerger.mergeWithGeoquest(baseInfos, results);
	}
}
