package br.com.mind5.business.material.info;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatMergerMatGroup extends InfoMergerTemplate<MatInfo, MatGroupInfo> {

	@Override protected InfoMergerVisitor<MatInfo, MatGroupInfo> getVisitorHook() {
		return new MatVisiMergeMatGroup();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
