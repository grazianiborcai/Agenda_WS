package br.com.mind5.business.ownerSnapshot.info;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class OwnerapMerger {
	public static OwnerapInfo mergeToSelect(OwnerapInfo sourceOne, OwnerapInfo sourceTwo) {
		InfoMerger_<OwnerapInfo, OwnerapInfo> merger = new OwnerapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerapInfo> mergeToSelect(List<OwnerapInfo> sourceOnes, List<OwnerapInfo> sourceTwos) {
		InfoMerger_<OwnerapInfo, OwnerapInfo> merger = new OwnerapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OwnerapInfo mergeWithComplis(ComplisInfo sourceOne, OwnerapInfo sourceTwo) {
		InfoMerger_<OwnerapInfo, ComplisInfo> merger = new OwnerapMergerComplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerapInfo> mergeWithComplis(List<ComplisInfo> sourceOnes, List<OwnerapInfo> sourceTwos) {
		InfoMerger_<OwnerapInfo, ComplisInfo> merger = new OwnerapMergerComplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OwnerapInfo mergeWithPersolis(PersolisInfo sourceOne, OwnerapInfo sourceTwo) {
		InfoMerger_<OwnerapInfo, PersolisInfo> merger = new OwnerapMergerPersolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerapInfo> mergeWithPersolis(List<PersolisInfo> sourceOnes, List<OwnerapInfo> sourceTwos) {
		InfoMerger_<OwnerapInfo, PersolisInfo> merger = new OwnerapMergerPersolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OwnerapInfo mergeWithUselis(UselisInfo sourceOne, OwnerapInfo sourceTwo) {
		InfoMerger_<OwnerapInfo, UselisInfo> merger = new OwnerapMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerapInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<OwnerapInfo> sourceTwos) {
		InfoMerger_<OwnerapInfo, UselisInfo> merger = new OwnerapMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
