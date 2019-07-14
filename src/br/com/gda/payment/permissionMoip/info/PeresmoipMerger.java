package br.com.gda.payment.permissionMoip.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;

public final class PeresmoipMerger {	
	public static PeresmoipInfo mergeWithTokemoip(TokemoipInfo sourceOne, PeresmoipInfo sourceTwo) {
		InfoMerger<PeresmoipInfo, TokemoipInfo> merger = new PeresmoipMergerTokemoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PeresmoipInfo> mergeWithTokemoip(List<TokemoipInfo> sourceOnes, List<PeresmoipInfo> sourceTwos) {
		InfoMerger<PeresmoipInfo, TokemoipInfo> merger = new PeresmoipMergerTokemoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PeresmoipInfo mergeToSelect(PeresmoipInfo sourceOne, PeresmoipInfo sourceTwo) {
		InfoMerger<PeresmoipInfo, PeresmoipInfo> merger = new PeresmoipMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PeresmoipInfo> mergeToSelect(List<PeresmoipInfo> sourceOnes, List<PeresmoipInfo> sourceTwos) {
		InfoMerger<PeresmoipInfo, PeresmoipInfo> merger = new PeresmoipMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
