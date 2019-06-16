package br.com.gda.payment.ownerPartner.info;

import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.payment.countryPartner.info.CounparInfo;

public final class OwnparMerger {	
	public static OwnparInfo mergeWithCounpar(CounparInfo sourceOne, OwnparInfo sourceTwo) {
		InfoMerger<OwnparInfo, CounparInfo> merger = new OwnparMergerCounpar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnparInfo> mergeWithCounpar(List<CounparInfo> sourceOnes, List<OwnparInfo> sourceTwos) {
		InfoMerger<OwnparInfo, CounparInfo> merger = new OwnparMergerCounpar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OwnparInfo mergeWithOwner(OwnerInfo sourceOne, OwnparInfo sourceTwo) {
		InfoMerger<OwnparInfo, OwnerInfo> merger = new OwnparMergerOwner();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnparInfo> mergeWithOwner(List<OwnerInfo> sourceOnes, List<OwnparInfo> sourceTwos) {
		InfoMerger<OwnparInfo, OwnerInfo> merger = new OwnparMergerOwner();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
