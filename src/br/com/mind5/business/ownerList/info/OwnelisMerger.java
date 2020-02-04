package br.com.mind5.business.ownerList.info;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class OwnelisMerger {
	public static OwnelisInfo mergeWithComplis(ComplisInfo sourceOne, OwnelisInfo sourceTwo) {
		InfoMerger_<OwnelisInfo, ComplisInfo> merger = new OwnelisMergerComplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnelisInfo> mergeWithComplis(List<ComplisInfo> sourceOnes, List<OwnelisInfo> sourceTwos) {
		InfoMerger_<OwnelisInfo, ComplisInfo> merger = new OwnelisMergerComplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static OwnelisInfo mergeToSelect(OwnelisInfo sourceOne, OwnelisInfo sourceTwo) {
		InfoMerger_<OwnelisInfo, OwnelisInfo> merger = new OwnelisMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnelisInfo> mergeToSelect(List<OwnelisInfo> sourceOnes, List<OwnelisInfo> sourceTwos) {
		InfoMerger_<OwnelisInfo, OwnelisInfo> merger = new OwnelisMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
