package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerTemplateV2;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerPhone extends InfoMergerTemplateV2<StolisInfo, PhoneInfo> {

	@Override protected StolisInfo writeHook(PhoneInfo selectedInfo, StolisInfo baseInfo) {
		baseInfo.phones.add(selectedInfo);

		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(PhoneInfo selectedInfo, StolisInfo baseInfo) {
		return (selectedInfo.codOwner 	== baseInfo.codOwner 	&&
				selectedInfo.codStore 	== baseInfo.codStore		);
	}
	
	
	
	@Override protected List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();
		return uniquifier.uniquify(results);
	}
}
