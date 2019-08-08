package br.com.gda.business.materialStock.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class MatockMergerToUpdate extends InfoMergerTemplate<MatockInfo, MatockInfo> {

	@Override protected InfoMergerVisitor<MatockInfo, MatockInfo> getVisitorHook() {
		return new MatockVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<MatockInfo> getUniquifierHook() {
		return new MatockUniquifier();
	}
}
