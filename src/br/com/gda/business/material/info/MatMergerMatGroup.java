package br.com.gda.business.material.info;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class MatMergerMatGroup extends InfoMergerTemplate<MatInfo, MatGroupInfo> {

	@Override protected InfoMergerVisitorV2<MatInfo, MatGroupInfo> getVisitorHook() {
		return new MatVisiMergeMatGroup();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
