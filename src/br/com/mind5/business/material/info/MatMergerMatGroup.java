package br.com.mind5.business.material.info;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatMergerMatGroup extends InfoMergerTemplate_<MatInfo, MatGroupInfo> {

	@Override protected InfoMergerVisitor_<MatInfo, MatGroupInfo> getVisitorHook() {
		return new MatVisiMergeMatGroup();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
