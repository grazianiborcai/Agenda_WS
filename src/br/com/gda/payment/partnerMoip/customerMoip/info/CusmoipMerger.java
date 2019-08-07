package br.com.gda.payment.partnerMoip.customerMoip.info;

import java.util.List;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMerger;

public final class CusmoipMerger {
	public static CusmoipInfo mergeWithSysEnviron(SysEnvironInfo sourceOne, CusmoipInfo sourceTwo) {
		InfoMerger<CusmoipInfo, SysEnvironInfo> merger = new CusmoipMergerSysEnviron();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusmoipInfo> mergeWithSysEnviron(List<SysEnvironInfo> sourceOnes, List<CusmoipInfo> sourceTwos) {
		InfoMerger<CusmoipInfo, SysEnvironInfo> merger = new CusmoipMergerSysEnviron();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
