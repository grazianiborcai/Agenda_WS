package br.com.mind5.business.storeList.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolisMergerFimist extends InfoMergerTemplate_<StolisInfo, FimistInfo> {

	@Override protected InfoMergerVisitor_<StolisInfo, FimistInfo> getVisitorHook() {
		return new StolisVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
