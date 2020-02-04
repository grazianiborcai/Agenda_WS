package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplateV2_;

final class StolisMergerFimist extends InfoMergerTemplateV2_<StolisInfo, FimistInfo> {

	@Override protected StolisInfo writeHook(FimistInfo selectedInfo, StolisInfo baseInfo) {
		baseInfo.fimistes.add(selectedInfo);

		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(FimistInfo selectedInfo, StolisInfo baseInfo) {
		return (selectedInfo.codOwner 	== baseInfo.codOwner &&
				selectedInfo.codStore 	== baseInfo.codStore		);
	}
	
	
	
	@Override protected List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();
		return uniquifier.uniquify(results);
	}
}
