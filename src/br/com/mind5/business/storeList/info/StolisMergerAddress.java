package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerTemplateV2;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerAddress extends InfoMergerTemplateV2<StolisInfo, AddressInfo> {

	@Override protected StolisInfo writeHook(AddressInfo selectedInfo, StolisInfo baseInfo) {
		baseInfo.addresses.add(selectedInfo);

		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(AddressInfo selectedInfo, StolisInfo baseInfo) {
		return (selectedInfo.codOwner 	== baseInfo.codOwner &&
				selectedInfo.codStore 	== baseInfo.codStore		);
	}
	
	
	
	@Override protected List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();
		return uniquifier.uniquify(results);
	}
}
