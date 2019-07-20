package br.com.gda.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class PayordemCopyPayord extends InfoCopierOneToManyTemplate<PayordemInfo, PayordInfo>{
	
	public PayordemCopyPayord() {
		super();
	}
	
	
	
	@Override protected List<PayordemInfo> makeCopyHook(PayordInfo source) {	
		List<PayordemInfo> results = new ArrayList<>();
		int itemNum = 1;
		
		for(OrderemInfo eachItem : source.orderData.orderms) {
			PayordemInfo oneResult = PayordemInfo.copyFrom(eachItem);
			oneResult.codPayOrder = source.codPayOrder;
			oneResult.codPayPartner = source.codPayPartner;
			oneResult.itemNum = itemNum++;
			
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
		feeItem.itemNum = itemNum;
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
