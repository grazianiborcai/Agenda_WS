package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatsnapMergerMatCateg extends InfoMergerTemplate_<MatsnapInfo, MatCategInfo> {

	@Override protected InfoMergerVisitor_<MatsnapInfo, MatCategInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatCateg();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
