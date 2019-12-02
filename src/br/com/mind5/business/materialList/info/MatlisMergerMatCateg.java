package br.com.mind5.business.materialList.info;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatlisMergerMatCateg extends InfoMergerTemplate<MatlisInfo, MatCategInfo> {

	@Override protected InfoMergerVisitor<MatlisInfo, MatCategInfo> getVisitorHook() {
		return new MatlisVisiMergeMatCateg();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
