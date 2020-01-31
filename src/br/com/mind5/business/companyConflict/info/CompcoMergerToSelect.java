package br.com.mind5.business.companyConflict.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CompcoMergerToSelect extends InfoMergerTemplate_<CompcoInfo, CompcoInfo> {

	@Override protected InfoMergerVisitor_<CompcoInfo, CompcoInfo> getVisitorHook() {
		return new CompcoVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CompcoInfo> getUniquifierHook() {
		return new CompcoUniquifier();
	}	
}
