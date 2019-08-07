package br.com.gda.payment.partnerMoip.multiPayMoip.info;

import java.util.List;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMerger;

public final class PaymoipMerger {
	public static PaymoipInfo mergeWithSysEnviron(SysEnvironInfo sourceOne, PaymoipInfo sourceTwo) {
		InfoMerger<PaymoipInfo, SysEnvironInfo> merger = new PaymoipMergerSysEnviron();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaymoipInfo> mergeWithSysEnviron(List<SysEnvironInfo> sourceOnes, List<PaymoipInfo> sourceTwos) {
		InfoMerger<PaymoipInfo, SysEnvironInfo> merger = new PaymoipMergerSysEnviron();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
