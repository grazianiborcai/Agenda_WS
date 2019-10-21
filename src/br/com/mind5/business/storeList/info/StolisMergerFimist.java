package br.com.mind5.business.storeList.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerFimist extends InfoMergerTemplate<StolisInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<StolisInfo, FimistInfo> getVisitorHook() {
		return new StolisVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
