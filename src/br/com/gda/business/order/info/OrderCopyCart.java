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
		//result.codOrderStatus;
		//result.cusCpf;
		//result.cusEmail;
		//result.cusName;
		//result.codLanguage;
		//result.cusCodCountry;
		//result.cusCodState;
		result.codStore = source.codStore;
		result.codMat = source.codMat;
		result.matTxt = source.txtMat;
		result.matUnit = source.codUnit;
		result.matPrice = source.price;
		result.matQuantity = source.quantity;
		result.matCodCurr = source.codCurr;
		//result.matCodType;
		//result.matCodCategory;
		result.matPriceUnit = source.priceUnit;
		//result.matCodGroup;
		result.matBeginTime = source.beginTime;
		result.matEndTime = source.endTime;
		result.matDate = source.date;
		//result.storeCnpj;
		//result.storeInscMunicipal;
		//result.storeInscEstadual;
		result.storeName = source.nameStore;
		//result.storeCountry;
		//result.storeStateProvince;
		//result.storeCodCurr;
		//result.storeCodTimezone;
		result.codEmployee = source.codEmployee;
		//result.empCpf;
		result.empName = source.nameEmployee;
		
		return result;
	}
}
