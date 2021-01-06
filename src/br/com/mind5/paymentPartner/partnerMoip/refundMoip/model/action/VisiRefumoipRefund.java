package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.moip.Moip;

final class VisiRefumoipRefund extends ActionVisitorTemplateSimple<RefumoipInfo> {
	
	public VisiRefumoipRefund(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<RefumoipInfo> executeTransformationHook(List<RefumoipInfo> recordInfos) {
		List<RefumoipInfo> results = new ArrayList<>();
		
		for(RefumoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = refundOrder(eachRecod);
			
			if (response == null)
				return null;
			
			eachRecod.response = response;
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> refundOrder(RefumoipInfo recordInfo) {
		try {
			return Moip.API.refunds().refundOrder(recordInfo.idOrderPartner, recordInfo.setup);	
		
		} catch (Exception e) {
			super.logException(e);
			return null;
		}
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.REFUND_MOIP_REFUND_ERROR;
	}
}
