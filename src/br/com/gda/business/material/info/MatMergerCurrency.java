package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMerger;

final class MatMergerCurrency extends InfoMerger<MatInfo, CurrencyInfo, MatInfo> {
	public MatInfo merge(CurrencyInfo sourceOne, MatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatVisitorCurrency());
	}
	
	
	
	public List<MatInfo> merge(List<CurrencyInfo> sourceOnes, List<MatInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatVisitorCurrency());
	}
}
