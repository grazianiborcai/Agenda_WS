package br.com.gda.business.companyList.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class ComplisMerger {	
	public static ComplisInfo mergeToSelect(ComplisInfo sourceOne, ComplisInfo sourceTwo) {
		InfoMerger<ComplisInfo, ComplisInfo> merger = new ComplisMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ComplisInfo> mergeToSelect(List<ComplisInfo> sourceOnes, List<ComplisInfo> sourceTwos) {
		InfoMerger<ComplisInfo, ComplisInfo> merger = new ComplisMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
