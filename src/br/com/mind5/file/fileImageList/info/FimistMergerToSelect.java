package br.com.mind5.file.fileImageList.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class FimistMergerToSelect extends InfoMergerTemplate_<FimistInfo, FimistInfo> {

	@Override protected InfoMergerVisitor_<FimistInfo, FimistInfo> getVisitorHook() {
		return new FimistVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<FimistInfo> getUniquifierHook() {
		return new FimistUniquifier();
	}
}
