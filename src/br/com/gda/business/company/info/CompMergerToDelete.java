package br.com.gda.business.company.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class CompMergerToDelete extends InfoMergerTemplate<CompInfo, CompInfo> {
	@Override protected InfoMergerVisitor<CompInfo, CompInfo> getVisitorHook() {
		return new CompVisiMergeToDelete();
	}
}
