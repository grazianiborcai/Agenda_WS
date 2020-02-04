package br.com.mind5.payment.ownerPartner.info;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class OwnparMerger {	
	public static OwnparInfo mergeWithCounpar(CounparInfo sourceOne, OwnparInfo sourceTwo) {
		InfoMerger_<OwnparInfo, CounparInfo> merger = new OwnparMergerCounpar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnparInfo> mergeWithCounpar(List<CounparInfo> sourceOnes, List<OwnparInfo> sourceTwos) {
		InfoMerger_<OwnparInfo, CounparInfo> merger = new OwnparMergerCounpar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OwnparInfo mergeWithOwner(OwnerInfo sourceOne, OwnparInfo sourceTwo) {
		InfoMerger_<OwnparInfo, OwnerInfo> merger = new OwnparMergerOwner();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnparInfo> mergeWithOwner(List<OwnerInfo> sourceOnes, List<OwnparInfo> sourceTwos) {
		InfoMerger_<OwnparInfo, OwnerInfo> merger = new OwnparMergerOwner();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OwnparInfo mergeToSelect(OwnparInfo sourceOne, OwnparInfo sourceTwo) {
		InfoMerger_<OwnparInfo, OwnparInfo> merger = new OwnparMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnparInfo> mergeToSelect(List<OwnparInfo> sourceOnes, List<OwnparInfo> sourceTwos) {
		InfoMerger_<OwnparInfo, OwnparInfo> merger = new OwnparMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
