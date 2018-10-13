package br.com.gda.business.order.info;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.info.InfoCopierTemplate;

final class OrderCopyCart extends InfoCopierTemplate<OrderInfo, CartInfo>{
	
	public OrderCopyCart() {
		super();
	}
	
	
	
	@Override protected OrderInfo makeCopyHook(CartInfo source) {
		OrderInfo result = new OrderInfo();
			
		result.codOwner = source.codOwner;
		result.itemNumber = source.itemNumber;
		result.codCustomer = source.codCustomer;	
		result.codItemCateg = source.codItemCateg;
		result.codStore = source.codStore;
		result.codMat = source.codMat;
		result.matTxt = source.txtMat;
		result.matUnit = source.codUnit;
		result.matPrice = source.price;
		result.matQuantity = source.quantity;
		result.matCodCurr = source.codCurr;
		result.matPriceUnit = source.priceUnit;
		result.matBeginTime = source.beginTime;
		result.matEndTime = source.endTime;
		result.matDate = source.date;
		result.storeName = source.nameStore;
		result.codEmployee = source.codEmployee;
		result.empName = source.nameEmployee;
		
		return result;
	}
}
