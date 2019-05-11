package br.com.gda.payService.payCustomer.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class PaycusMergerPaypar extends InfoMerger_<PaycusInfo, PayparInfo, PaycusInfo> {
	public PaycusInfo merge(PayparInfo sourceOne, PaycusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PaycusVisiPaypar());
	}
	
	
	
	public List<PaycusInfo> merge(List<PayparInfo> sourceOnes, List<PaycusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PaycusVisiPaypar());
	}
}
