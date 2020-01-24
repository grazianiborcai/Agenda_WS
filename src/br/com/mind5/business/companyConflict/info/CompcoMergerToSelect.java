package br.com.mind5.business.companyConflict.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CompcoMergerToSelect extends InfoMergerTemplate<CompcoInfo, CompcoInfo> {

	@Override protected InfoMergerVisitor<CompcoInfo, CompcoInfo> getVisitorHook() {
		return new CompcoVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CompcoInfo> getUniquifierHook() {
		return new CompcoUniquifier();
	}	
}
