package br.com.gda.business.materialSnapshot.info;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class MatsnapMergerMatCateg extends InfoMergerTemplate<MatsnapInfo, MatCategInfo> {

	@Override protected InfoMergerVisitor<MatsnapInfo, MatCategInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatCateg();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
