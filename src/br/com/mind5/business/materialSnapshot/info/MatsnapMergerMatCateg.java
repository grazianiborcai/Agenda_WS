package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatsnapMergerMatCateg extends InfoMergerTemplate<MatsnapInfo, MatCategInfo> {

	@Override protected InfoMergerVisitor<MatsnapInfo, MatCategInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatCateg();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
