package br.com.gda.business.materialStock.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class MatockMergerToSelect extends InfoMergerTemplate<MatockInfo, MatockInfo> {

	@Override protected InfoMergerVisitorV2<MatockInfo, MatockInfo> getVisitorHook() {
		return new MatockVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatockInfo> getUniquifierHook() {
		return new MatockUniquifier();
	}
}
