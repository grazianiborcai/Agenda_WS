package br.com.gda.business.materialSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMerger;

final class MatSnapMergerCurrency extends InfoMerger<MatSnapInfo, CurrencyInfo, MatSnapInfo> {
	public MatSnapInfo merge(CurrencyInfo sourceOne, MatSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatSnapVisitorCurrency());
	}
	
	
	
	public List<MatSnapInfo> merge(List<CurrencyInfo> sourceOnes, List<MatSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatSnapVisitorCurrency());
	}
}
