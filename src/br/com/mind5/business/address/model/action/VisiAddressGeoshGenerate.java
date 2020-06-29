package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.geo.geoHash.model.decisionTree.RootGeoshGenerate;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddressGeoshGenerate extends ActionVisitorTemplateActionV2<AddressInfo, GeoshInfo> {

	public VisiAddressGeoshGenerate(DeciTreeOption<AddressInfo> option) {
		super(option, AddressInfo.class, GeoshInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<GeoshInfo>> getTreeClassHook() {
		return RootGeoshGenerate.class;
	}
	
	
	
	@Override protected List<AddressInfo> toBaseClassHook(List<AddressInfo> baseInfos, List<GeoshInfo> results) {
		return AddressMerger.mergeWithGeosh(baseInfos, results);
	}
}
