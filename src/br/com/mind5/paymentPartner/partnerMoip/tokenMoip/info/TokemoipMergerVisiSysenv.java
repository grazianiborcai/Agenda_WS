package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

final class TokemoipMergerVisiSysenv extends InfoMergerVisitorTemplate<TokemoipInfo, SysenvInfo> {

	@Override public boolean shouldMerge(TokemoipInfo baseInfo, SysenvInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<TokemoipInfo> merge(TokemoipInfo baseInfo, SysenvInfo selectedInfo) {
		List<TokemoipInfo> results = new ArrayList<>();
		
		baseInfo.codSysEnviron = selectedInfo.codSysEnviron;;
		
		results.add(baseInfo);
		return results;
	}
}
