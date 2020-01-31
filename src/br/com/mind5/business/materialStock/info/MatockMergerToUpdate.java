package br.com.mind5.business.materialStock.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatockMergerToUpdate extends InfoMergerTemplate_<MatockInfo, MatockInfo> {

	@Override protected InfoMergerVisitor_<MatockInfo, MatockInfo> getVisitorHook() {
		return new MatockVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<MatockInfo> getUniquifierHook() {
		return new MatockUniquifier();
	}
}
