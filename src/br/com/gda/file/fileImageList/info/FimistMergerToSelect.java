package br.com.gda.file.fileImageList.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class FimistMergerToSelect extends InfoMergerTemplate<FimistInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<FimistInfo, FimistInfo> getVisitorHook() {
		return new FimistVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<FimistInfo> getUniquifierHook() {
		return new FimistUniquifier();
	}
}
