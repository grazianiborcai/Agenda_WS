package br.com.mind5.payment.partnerMoip.customerMoip.info;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class CusmoipMerger {
	public static CusmoipInfo mergeWithSysEnviron(SysEnvironInfo sourceOne, CusmoipInfo sourceTwo) {
		InfoMerger_<CusmoipInfo, SysEnvironInfo> merger = new CusmoipMergerSysEnviron();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusmoipInfo> mergeWithSysEnviron(List<SysEnvironInfo> sourceOnes, List<CusmoipInfo> sourceTwos) {
		InfoMerger_<CusmoipInfo, SysEnvironInfo> merger = new CusmoipMergerSysEnviron();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
