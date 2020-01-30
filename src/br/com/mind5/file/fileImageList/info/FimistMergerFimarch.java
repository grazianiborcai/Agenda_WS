package br.com.mind5.file.fileImageList.info;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class FimistMergerFimarch extends InfoMergerTemplate<FimistInfo, FimarchInfo> {

	@Override protected InfoMergerVisitor<FimistInfo, FimarchInfo> getVisitorHook() {
		return new FimistVisiMergeFimarch();
	}
	
	
	
	@Override protected InfoUniquifier<FimistInfo> getUniquifierHook() {
		return new FimistUniquifier();
	}
}
