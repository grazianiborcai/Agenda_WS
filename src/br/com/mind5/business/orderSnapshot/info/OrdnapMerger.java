package br.com.mind5.business.orderSnapshot.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class OrdnapMerger {		
	public static OrdnapInfo mergeWithCuslis(CuslisInfo sourceOne, OrdnapInfo sourceTwo) {
		InfoMerger_<OrdnapInfo, CuslisInfo> merger = new OrdnapMergerCuslis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdnapInfo> mergeWithCuslis(List<CuslisInfo> sourceOnes, List<OrdnapInfo> sourceTwos) {
		InfoMerger_<OrdnapInfo, CuslisInfo> merger = new OrdnapMergerCuslis();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrdnapInfo mergeWithUselis(UselisInfo sourceOne, OrdnapInfo sourceTwo) {
		InfoMerger_<OrdnapInfo, UselisInfo> merger = new OrdnapMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdnapInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<OrdnapInfo> sourceTwos) {
		InfoMerger_<OrdnapInfo, UselisInfo> merger = new OrdnapMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrdnapInfo mergeToSelect(OrdnapInfo sourceOne, OrdnapInfo sourceTwo) {
		InfoMerger_<OrdnapInfo, OrdnapInfo> merger = new OrdnapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdnapInfo> mergeToSelect(List<OrdnapInfo> sourceOnes, List<OrdnapInfo> sourceTwos) {
		InfoMerger_<OrdnapInfo, OrdnapInfo> merger = new OrdnapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
