package br.com.mind5.business.materialList.info;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatlisMergerMatCateg extends InfoMergerTemplate_<MatlisInfo, MatCategInfo> {

	@Override protected InfoMergerVisitor_<MatlisInfo, MatCategInfo> getVisitorHook() {
		return new MatlisVisiMergeMatCateg();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
