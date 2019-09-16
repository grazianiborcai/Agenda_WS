package br.com.gda.business.ownerSnapshot.info;

import java.util.List;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.userList.info.UselisInfo;

public final class OwnerapMerger {
	public static OwnerapInfo mergeToSelect(OwnerapInfo sourceOne, OwnerapInfo sourceTwo) {
		InfoMerger<OwnerapInfo, OwnerapInfo> merger = new OwnerapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerapInfo> mergeToSelect(List<OwnerapInfo> sourceOnes, List<OwnerapInfo> sourceTwos) {
		InfoMerger<OwnerapInfo, OwnerapInfo> merger = new OwnerapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OwnerapInfo mergeWithPersolis(PersolisInfo sourceOne, OwnerapInfo sourceTwo) {
		InfoMerger<OwnerapInfo, PersolisInfo> merger = new OwnerapMergerPersolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerapInfo> mergeWithPersolis(List<PersolisInfo> sourceOnes, List<OwnerapInfo> sourceTwos) {
		InfoMerger<OwnerapInfo, PersolisInfo> merger = new OwnerapMergerPersolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OwnerapInfo mergeWithUselis(UselisInfo sourceOne, OwnerapInfo sourceTwo) {
		InfoMerger<OwnerapInfo, UselisInfo> merger = new OwnerapMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerapInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<OwnerapInfo> sourceTwos) {
		InfoMerger<OwnerapInfo, UselisInfo> merger = new OwnerapMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
