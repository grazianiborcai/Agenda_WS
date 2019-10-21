package br.com.mind5.file.fileImageList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class FimistMergerToSelect extends InfoMergerTemplate<FimistInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<FimistInfo, FimistInfo> getVisitorHook() {
		return new FimistVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<FimistInfo> getUniquifierHook() {
		return new FimistUniquifier();
	}
}
