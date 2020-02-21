package br.com.mind5.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class PayordemCopyPayordToWrite_ extends InfoCopierOneToManyTemplate<PayordemInfo, PayordInfo>{
	
	public PayordemCopyPayordToWrite_() {
		super();
	}
	
	
	
	@Override protected List<PayordemInfo> makeCopyHook(PayordInfo source) {	
		List<PayordemInfo> results = new ArrayList<>();
		int itemNum = 1;
		
		for(OrderemInfo eachItem : source.orderData.orderms) {
			PayordemInfo oneResult = PayordemInfo.copyFrom(eachItem);
			oneResult.codPayOrder = source.codPayOrder;
			oneResult.codPayPartner = source.codPayPartner;
			oneResult.codPayOrderItem = itemNum++;
			
			results.add(oneResult);
		}
		
		
		PayordemInfo feeItem = makeFeeItem(source, itemNum);
		results.add(feeItem);
		
		return results;
	}
	
	
	
	private PayordemInfo makeFeeItem(PayordInfo source, int itemNum) {
		PayordemInfo feeItem = new PayordemInfo();
		
		feeItem.codOwner = source.orderData.codOwner;
		feeItem.codPayOrder = source.codPayOrder; 
		feeItem.codFeeCateg = source.orderData.codFeeCateg;
		feeItem.codPayOrderItem = itemNum;
		feeItem.codPayPartner = source.codPayPartner; 
		feeItem.quantity = 1;		
		feeItem.price = source.orderData.feeService;
		feeItem.totitem = source.orderData.feeService;
		feeItem.codCurr = source.orderData.codCurr;
		feeItem.itemReceiver = source.sysparData.idPayPartnerSystem;
		feeItem.codLanguage = source.codLanguage;
		feeItem.username = source.username;		
		
		return feeItem;
	}
}
