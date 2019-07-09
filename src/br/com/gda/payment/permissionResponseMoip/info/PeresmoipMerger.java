package br.com.gda.payment.permissionResponseMoip.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class PeresmoipMerger {	
	public static PeresmoipInfo mergeToSelect(PeresmoipInfo sourceOne, PeresmoipInfo sourceTwo) {
		InfoMerger<PeresmoipInfo, PeresmoipInfo> merger = new PeresmoipMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PeresmoipInfo> mergeToSelect(List<PeresmoipInfo> sourceOnes, List<PeresmoipInfo> sourceTwos) {
		InfoMerger<PeresmoipInfo, PeresmoipInfo> merger = new PeresmoipMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
