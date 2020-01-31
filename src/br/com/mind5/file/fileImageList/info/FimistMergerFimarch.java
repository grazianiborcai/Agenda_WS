package br.com.mind5.file.fileImageList.info;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class FimistMergerFimarch extends InfoMergerTemplate_<FimistInfo, FimarchInfo> {

	@Override protected InfoMergerVisitor_<FimistInfo, FimarchInfo> getVisitorHook() {
		return new FimistVisiMergeFimarch();
	}
	
	
	
	@Override protected InfoUniquifier<FimistInfo> getUniquifierHook() {
		return new FimistUniquifier();
	}
}
