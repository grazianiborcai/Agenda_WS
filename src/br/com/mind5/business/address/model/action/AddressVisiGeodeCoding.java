package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.geo.geoCode.model.decisionTree.RootGeodeCoding;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddressVisiGeodeCoding extends ActionVisitorTemplateAction<AddressInfo, GeodeInfo> {

	public AddressVisiGeodeCoding(DeciTreeOption<AddressInfo> option) {
		super(option, AddressInfo.class, GeodeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<GeodeInfo>> getTreeClassHook() {
		return RootGeodeCoding.class;
	}
	
	
	
	@Override protected List<AddressInfo> toBaseClassHook(List<AddressInfo> baseInfos, List<GeodeInfo> results) {
		return AddressMerger.mergeWithGeode(baseInfos, results);
	}
}
