package br.com.mind5.business.materialStock.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatockMergerToUpdate extends InfoMergerTemplate<MatockInfo, MatockInfo> {

	@Override protected InfoMergerVisitor<MatockInfo, MatockInfo> getVisitorHook() {
		return new MatockVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<MatockInfo> getUniquifierHook() {
		return new MatockUniquifier();
	}
}
