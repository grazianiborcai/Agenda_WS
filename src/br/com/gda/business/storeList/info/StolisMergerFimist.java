package br.com.gda.business.storeList.info;

import br.com.gda.file.fileImageList.info.FimistInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StolisMergerFimist extends InfoMergerTemplate<StolisInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<StolisInfo, FimistInfo> getVisitorHook() {
		return new StolisVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
