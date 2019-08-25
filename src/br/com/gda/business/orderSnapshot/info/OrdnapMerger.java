package br.com.gda.business.orderSnapshot.info;

import java.util.List;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.userList.info.UselisInfo;

public final class OrdnapMerger {		
	public static OrdnapInfo mergeWithCusarch(CusarchInfo sourceOne, OrdnapInfo sourceTwo) {
		InfoMerger<OrdnapInfo, CusarchInfo> merger = new OrdnapMergerCusarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdnapInfo> mergeWithCusarch(List<CusarchInfo> sourceOnes, List<OrdnapInfo> sourceTwos) {
		InfoMerger<OrdnapInfo, CusarchInfo> merger = new OrdnapMergerCusarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrdnapInfo mergeWithUselis(UselisInfo sourceOne, OrdnapInfo sourceTwo) {
		InfoMerger<OrdnapInfo, UselisInfo> merger = new OrdnapMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdnapInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<OrdnapInfo> sourceTwos) {
		InfoMerger<OrdnapInfo, UselisInfo> merger = new OrdnapMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrdnapInfo mergeToSelect(OrdnapInfo sourceOne, OrdnapInfo sourceTwo) {
		InfoMerger<OrdnapInfo, OrdnapInfo> merger = new OrdnapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdnapInfo> mergeToSelect(List<OrdnapInfo> sourceOnes, List<OrdnapInfo> sourceTwos) {
		InfoMerger<OrdnapInfo, OrdnapInfo> merger = new OrdnapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
