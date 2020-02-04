package br.com.mind5.business.companyList.info;

import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class ComplisMerger {	
	public static ComplisInfo mergeWithComparch(ComparchInfo sourceOne, ComplisInfo sourceTwo) {
		InfoMerger_<ComplisInfo, ComparchInfo> merger = new ComplisMergerComparch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ComplisInfo> mergeWithComparch(List<ComparchInfo> sourceOnes, List<ComplisInfo> sourceTwos) {
		InfoMerger_<ComplisInfo, ComparchInfo> merger = new ComplisMergerComparch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static ComplisInfo mergeToSelect(ComplisInfo sourceOne, ComplisInfo sourceTwo) {
		InfoMerger_<ComplisInfo, ComplisInfo> merger = new ComplisMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ComplisInfo> mergeToSelect(List<ComplisInfo> sourceOnes, List<ComplisInfo> sourceTwos) {
		InfoMerger_<ComplisInfo, ComplisInfo> merger = new ComplisMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
